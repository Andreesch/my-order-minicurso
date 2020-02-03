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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(new Product().setId(1).setValue(2.0), new Product().setId(2).setValue(3.0));
        System.out.println(products.stream().map(p -> p.getId()).collect(Collectors.toList()));
    }

    public Order create(OrderCreationDto orderCreationDto) {
        List<Product> products = findProductsById(orderCreationDto.getItems().stream()
                .map(OrderItemCreationDto::getItemId)
                .collect(Collectors.toList()));

        Order order = new Order()
                .setOrderStatus(OrderStatusEnum.OPEN)
                .setRestaurant(restaurantService.findRestaurantById(orderCreationDto.getRestaurantId()))
                .setUser(userService.findUserById(orderCreationDto.getUserId()))
                .setTotalValue(calculateTotalValue(orderCreationDto.getItems(), products));

        orderRepository.save(order);

        orderCreationDto.getItems().stream().map(i -> {
            OrderItem orderItem = new OrderItem()
                    .setOrder(order)
                    .setProduct(products.stream().filter(p -> p.getId().equals(i.getItemId())).findFirst().get())
                    .setQuantity(i.getQuantity());

            orderItemRepository.save(orderItem);
            return orderItem;
        }).collect(Collectors.toList());
        return order;
    }

    private Double calculateTotalValue(List<OrderItemCreationDto> items, List<Product> products) {
        BigDecimal totalValue = items.stream().map(orderItemCreationDto -> {
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
