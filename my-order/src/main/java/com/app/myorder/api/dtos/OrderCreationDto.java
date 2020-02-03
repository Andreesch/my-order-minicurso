package com.app.myorder.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderCreationDto {
    @NotNull
    private Integer userId;

    @NotNull
    private Integer restaurantId;

    @NotEmpty
    private List<OrderItemCreationDto> items;

    public Integer getUserId() {
        return userId;
    }

    public OrderCreationDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public OrderCreationDto setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public List<OrderItemCreationDto> getItems() {
        return items;
    }

    public OrderCreationDto setItems(List<OrderItemCreationDto> items) {
        this.items = items;
        return this;
    }
}
