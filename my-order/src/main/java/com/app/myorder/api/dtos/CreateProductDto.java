package com.app.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateProductDto {

    @NotEmpty
    @ApiModelProperty(value = "${product.create.name}")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "${product.create.description}")
    private String description;

    @NotNull
    @ApiModelProperty(value = "${product.create.double}")
    private Double value;

    @NotEmpty
    @ApiModelProperty(value = "${product.create.restaurantId}")
    private String restaurantId;

    public String getName() {
        return name;
    }

    public CreateProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CreateProductDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public CreateProductDto setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}
