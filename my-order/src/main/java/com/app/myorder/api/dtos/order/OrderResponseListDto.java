package com.app.myorder.api.dtos.order;

import java.util.List;

public class OrderResponseListDto {
    private List<OrderResponseDto> orders;

    public List<OrderResponseDto> getOrders() {
        return orders;
    }

    public OrderResponseListDto setOrders(List<OrderResponseDto> orders) {
        this.orders = orders;
        return this;
    }
}
