package com.app.myorder.services;

import com.app.myorder.api.dtos.order.OrderCreationDto;
import com.app.myorder.api.dtos.OrderItemCreationDto;
import com.app.myorder.config.Translator;
import com.app.myorder.entities.Order;
import com.app.myorder.entities.OrderItem;
import com.app.myorder.entities.Product;
import com.app.myorder.enums.OrderStatusEnum;
import com.app.myorder.exceptions.NotFoundException;
import com.app.myorder.helper.OrderHelper;
import com.app.myorder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

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

        Order order = new Order();

        return order.setOrderStatus(OrderStatusEnum.OPEN)
                .setUser(userService.findUserById(orderCreationDto.getUserId()))
                .setRestaurant(restaurantService.findRestaurantById(orderCreationDto.getRestaurantId()))
                .setTotalValue(OrderHelper.calculateTotalValue(orderCreationDto.getItems(), products))
                .setItems(createItems(orderCreationDto.getItems(), products, order));
    }

    public Order find(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("order.notfound.exception", new Integer[]{id})));
    }

    public List<Order> findAllByUserId(Integer id) {
        return orderRepository.listByUserId(id);
    }

    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    private List<OrderItem> createItems(List<OrderItemCreationDto> orderItemCreationDtos, List<Product> products, Order order) {

       return orderItemCreationDtos.stream()
                .map(orderItemCreationDto -> new OrderItem()
                        .setProduct(products.stream()
                                .filter(p -> p.getId().equals(orderItemCreationDto.getItemId()))
                                .findFirst()
                                .get())
                        .setQuantity(orderItemCreationDto.getQuantity())
                        .setOrder(order))
               .collect(Collectors.toList());
    }

    private List<Product> findProductsById(List<Integer> productsId) {
        return productService.findAllById(productsId);
    }
}
