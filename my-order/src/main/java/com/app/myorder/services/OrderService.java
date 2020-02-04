package com.app.myorder.services;

import com.app.myorder.api.dtos.OrderCreationDto;
import com.app.myorder.api.dtos.OrderItemCreationDto;
import com.app.myorder.entities.Order;
import com.app.myorder.entities.OrderItem;
import com.app.myorder.entities.Product;
import com.app.myorder.enums.OrderStatusEnum;
import com.app.myorder.repositories.OrderItemRepository;
import com.app.myorder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    public Order create(OrderCreationDto orderCreationDto) {
        return orderRepository.save(createOrder(orderCreationDto));
    }

    public Order createOrder(OrderCreationDto orderCreationDto) {
        List<Product> products = findProductsById(orderCreationDto.getItems()
                .stream()
                .map(OrderItemCreationDto::getItemId)
                .collect(Collectors.toList()));

        return new Order()
                .setOrderStatus(OrderStatusEnum.OPEN)
                .setUser(userService.findUserById(orderCreationDto.getUserId()))
                .setRestaurant(restaurantService.findRestaurantById(orderCreationDto.getRestaurantId()))
                .setTotalValue(calculateTotalValue(orderCreationDto.getItems(), products))
                .setItems(createItems(orderCreationDto.getItems(), products));
    }

    private List<OrderItem> createItems(List<OrderItemCreationDto> orderItemCreationDtos, List<Product> products) {

       return orderItemCreationDtos.stream()
                .map(orderItemCreationDto -> new OrderItem()
                        .setProduct(products.stream()
                                .filter(p -> p.getId().equals(orderItemCreationDto.getItemId()))
                                .findFirst()
                                .get())
                        .setQuantity(orderItemCreationDto.getQuantity()))
               .collect(Collectors.toList());
    }

    private Double calculateTotalValue(List<OrderItemCreationDto> items, List<Product> products) {
        BigDecimal totalValue = items.stream()
                .map(orderItemCreationDto -> {
                    Optional<Product> currentProduct = products.stream()
                            .filter(product -> product.getId().equals(orderItemCreationDto.getItemId()))
                            .findFirst();

            return calculateItemValue(orderItemCreationDto.getQuantity(), currentProduct.get());
        }).reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalValue.doubleValue();
    }

    private List<Product> findProductsById(List<Integer> productsId) {
        return productService.findAllById(productsId);
    }

    private BigDecimal calculateItemValue(Integer quantity, Product product) {
        return new BigDecimal(product.getValue())
                .multiply(new BigDecimal(quantity));
    }
}
