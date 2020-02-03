package com.app.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderItemCreationDto {

    @NotNull
    @ApiModelProperty(value = "${orderItem.create.itemId}")
    private Integer itemId;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "${orderItem.create.quantity}")
    private Integer quantity;

    public Integer getItemId() {
        return itemId;
    }

    public OrderItemCreationDto setItemId(Integer itemId) {
        this.itemId = itemId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemCreationDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
