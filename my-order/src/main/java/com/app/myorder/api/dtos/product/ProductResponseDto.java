package com.app.myorder.api.dtos.product;

import com.app.myorder.api.dtos.restaurant.RestaurantResponseDto;
import io.swagger.annotations.ApiModelProperty;

public class ProductResponseDto {

    @ApiModelProperty(value = "${product.create.id}")
    private Integer id;

    @ApiModelProperty(value = "${product.create.name}")
    private String name;

    @ApiModelProperty(value = "${product.create.description}")
    private String description;

    @ApiModelProperty(value = "${product.create.value}")
    private Double value;

    @ApiModelProperty(value = "${product.create.restaurant}")
    private RestaurantResponseDto restaurant;

    public Integer getId() {
        return id;
    }

    public ProductResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProductResponseDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public RestaurantResponseDto getRestaurant() {
        return restaurant;
    }

    public ProductResponseDto setRestaurant(RestaurantResponseDto restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
