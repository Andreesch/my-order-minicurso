package com.app.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

public class RestaurantFindResponseDto {

    @ApiModelProperty(value = "${restaurant.find.id}")
    private Integer id;

    @ApiModelProperty(value = "${restaurant.find.name}")
    private String name;

    @ApiModelProperty(value = "${restaurant.find.phone}")
    private String phone;

    @ApiModelProperty(value = "${restaurant.find.email}")
    private String email;

    public Integer getId() {
        return id;
    }

    public RestaurantFindResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantFindResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RestaurantFindResponseDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RestaurantFindResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
