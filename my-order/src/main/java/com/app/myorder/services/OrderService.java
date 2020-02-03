package com.app.myorder.services;

import com.app.myorder.api.dtos.OrderCreationDto;
import com.app.myorder.api.dtos.OrderItemCreationDto;
import com.app.myorder.entities.Order;
import com.app.myorder.entities.Product;
import com.app.myorder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public Order create(OrderCreationDto orderCreationDto) {

    }

    private Double calculateTotalValue(List<OrderItemCreationDto> items) {
        List<Product> products = findProductsById(items.stream()
                .map(OrderItemCreationDto::getItemId)
                .collect(Collectors.toList()));

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
                .multiply(new BigDecimal(product.getValue()));
    }
}
