package com.app.myorder.helper;

import com.app.myorder.api.dtos.OrderItemCreationDto;
import com.app.myorder.entities.Product;

import java.util.List;
import java.util.Optional;

public class OrderHelper {

    public static Double calculateTotalValue(List<OrderItemCreationDto> items, List<Product> products) {
        Double totalValue = items.stream()
                .map(orderItemCreationDto -> {
                    Optional<Product> currentProduct = products.stream()
                            .filter(product -> product.getId().equals(orderItemCreationDto.getItemId()))
                            .findFirst();

                    return calculateItemValue(orderItemCreationDto.getQuantity(), currentProduct.get());
                }).reduce(0d, Double::sum);

        return totalValue;
    }

    public static Double calculateItemValue(Integer quantity, Product product) {
        return product.getValue() * quantity;
    }
}
