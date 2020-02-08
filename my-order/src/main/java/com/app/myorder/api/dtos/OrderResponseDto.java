package com.app.myorder.api.dtos;

import com.app.myorder.api.dtos.order.OrderItemDto;
import com.app.myorder.api.dtos.restaurant.RestaurantResponseDto;
import com.app.myorder.api.dtos.user.UserResponseDto;
import com.app.myorder.enums.OrderStatusEnum;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class OrderResponseDto {

    @ApiModelProperty(value = "${order.find.id}")
    private Integer id;

    @ApiModelProperty(value = "${order.find.totalValue}")
    private Double totalValue;

    @ApiModelProperty(value = "${order.find.status}")
    private OrderStatusEnum orderStatus;

    @ApiModelProperty(value = "${order.find.user}")
    private UserResponseDto user;

    @ApiModelProperty(value = "${order.find.restaurant}")
    private RestaurantResponseDto restaurant;

    @ApiModelProperty(value = "${order.find.items}")
    private List<OrderItemDto> items;

    public Integer getId() {
        return id;
    }

    public OrderResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public OrderResponseDto setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public OrderResponseDto setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public UserResponseDto getUser() {
        return user;
    }

    public OrderResponseDto setUser(UserResponseDto user) {
        this.user = user;
        return this;
    }

    public RestaurantResponseDto getRestaurant() {
        return restaurant;
    }

    public OrderResponseDto setRestaurant(RestaurantResponseDto restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public OrderResponseDto setItems(List<OrderItemDto> items) {
        this.items = items;
        return this;
    }
}
