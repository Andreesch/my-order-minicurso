package com.app.myorder.api.dtos.product;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductUpdateDto {

    @NotNull
    @ApiModelProperty(value = "${product.update.id}")
    private Integer id;

    @NotEmpty
    @ApiModelProperty(value = "${product.update.name}")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "${product.update.description}")
    private String description;

    @NotNull
    @ApiModelProperty(value = "${product.update.value}")
    private Double value;

    @NotNull
    @ApiModelProperty(value = "${product.update.restaurantId}")
    private Integer restaurantId;

    public Integer getId() {
        return id;
    }

    public ProductUpdateDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductUpdateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductUpdateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProductUpdateDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public ProductUpdateDto setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}
