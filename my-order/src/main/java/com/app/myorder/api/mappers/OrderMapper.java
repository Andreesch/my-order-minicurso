package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.order.OrderResponseDto;
import com.app.myorder.api.dtos.order.OrderResponseListDto;
import com.app.myorder.entities.Order;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private OrderMapper() {

    };

    public static OrderResponseDto toResponseDto(Order order) {
        return modelMapper.map(order, OrderResponseDto.class);
    }

    public static OrderResponseDto toFindResponseDto(Order order) {
        return new OrderResponseDto()
                .setId(order.getId())
                .setTotalValue(order.getTotalValue())
                .setOrderStatus(order.getOrderStatus())
                .setUser(UserMapper.toResponseDto(order.getUser()))
                .setRestaurant(RestaurantMapper.toRestaurantResponseDto(order.getRestaurant()))
                .setItems(OrderItemMapper.toOrderItemDtoList(order.getItems()));
    }

    public static OrderResponseListDto toOrderResponseListDto(List<Order> orders) {
        return new OrderResponseListDto()
                .setOrders(orders.stream()
                    .map(OrderMapper::toFindResponseDto)
                        .collect(Collectors.toList()));
    }

}