package com.app.myorder.api.dtos;

import java.util.List;

import com.app.myorder.api.dtos.order.OrderItemDto;
import com.app.myorder.api.dtos.order.OrderRestaurantDto;
import com.app.myorder.api.dtos.order.OrderUserDto;
import com.app.myorder.enums.OrderStatusEnum;

import io.swagger.annotations.ApiModelProperty;

public class OrderFindResponseDto {

    @ApiModelProperty(value = "${order.find.id}")
    private Integer id;

    @ApiModelProperty(value = "${order.find.totalValue}")
    private Double totalValue;

    @ApiModelProperty(value = "${order.find.status}")
    private OrderStatusEnum orderStatus;

    @ApiModelProperty(value = "${order.find.user}")
    private OrderUserDto user;

    @ApiModelProperty(value = "${order.find.restaurant}")
    private OrderRestaurantDto restaurant;

    @ApiModelProperty(value = "${order.find.items}")
    private List<OrderItemDto> items;

    public Integer getId() {
        return id;
    }

    public OrderFindResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public OrderFindResponseDto setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public OrderFindResponseDto setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public OrderUserDto getUser() {
        return user;
    }

    public OrderFindResponseDto setUser(OrderUserDto user) {
        this.user = user;
        return this;
    }

    public OrderRestaurantDto getRestaurant() {
        return restaurant;
    }

    public OrderFindResponseDto setRestaurant(OrderRestaurantDto restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public OrderFindResponseDto setItems(List<OrderItemDto> items) {
        this.items = items;
        return this;
    }
}
