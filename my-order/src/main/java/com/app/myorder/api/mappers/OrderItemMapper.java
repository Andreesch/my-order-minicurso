package com.app.myorder.api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.app.myorder.api.dtos.order.OrderItemDto;
import com.app.myorder.entities.OrderItem;

public class OrderItemMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private OrderItemMapper(){

    };

    public static List<OrderItemDto> toOrderItemDtoList(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItemMapper::toOrderItemDto)
                .collect(Collectors.toList());
    }

    public static OrderItemDto toOrderItemDto(OrderItem orderItem) {
        return modelMapper.map(orderItem, OrderItemDto.class)
                .setProduct(ProductMapper.toProductDto(orderItem.getProduct()));
    }
}
