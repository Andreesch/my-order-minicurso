package com.app.myorder.api.dtos.product;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductCreateDto {

    @NotEmpty
    @ApiModelProperty(value = "${order.create.name}")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "${product.create.description}")
    private String description;

    @NotNull
    @ApiModelProperty(value = "${product.create.value}")
    private Double value;

    @NotNull
    @ApiModelProperty(value = "${product.create.restaurantId}")
    private Integer restaurantId;

    public String getName() {
        return name;
    }

    public ProductCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProductCreateDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public ProductCreateDto setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}
