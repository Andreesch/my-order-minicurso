package com.app.myorder.api.dtos.order;

import com.app.myorder.enums.OrderStatusEnum;

import javax.validation.constraints.NotNull;

public class OrderStatusChangeDto {

    @NotNull
    private Integer orderId;

    @NotNull
    private OrderStatusEnum orderStatusEnum;

    public Integer getOrderId() {
        return orderId;
    }

    public OrderStatusChangeDto setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public OrderStatusChangeDto setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
        return this;
    }
}
