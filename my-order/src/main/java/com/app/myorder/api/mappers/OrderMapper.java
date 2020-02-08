package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.OrderCreationResponseDto;
import com.app.myorder.api.dtos.OrderFindResponseDto;
import com.app.myorder.entities.Order;
import org.modelmapper.ModelMapper;

public class OrderMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private OrderMapper() {

    };

    public static OrderCreationResponseDto toResponseDto(Order order) {
        return modelMapper.map(order, OrderCreationResponseDto.class);
    }

    public static OrderFindResponseDto toFindResponseDto(Order order) {
        return new OrderFindResponseDto()
                .setId(order.getId())
                .setTotalValue(order.getTotalValue())
                .setUser(UserMapper.toOrderUserDto(order.getUser()))
                .setRestaurant(RestaurantMapper.toOrderRestaurantDto(order.getRestaurant()))
                .setItems(OrderItemMapper.toOrderItemDtoList(order.getItems()));

    }

}
