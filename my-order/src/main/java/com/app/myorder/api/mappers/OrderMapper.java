package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.OrderResponseDto;
import com.app.myorder.entities.Order;
import org.modelmapper.ModelMapper;

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

}
