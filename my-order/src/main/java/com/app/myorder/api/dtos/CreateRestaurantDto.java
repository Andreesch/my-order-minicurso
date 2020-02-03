package com.app.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateRestaurantDto {

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${restaurant.create.name}")
    private String name;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${restaurant.create.phone}")
    private String phone;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${restaurant.create.email}")
    private String email;

    public String getName() {
        return name;
    }

    public CreateRestaurantDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateRestaurantDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateRestaurantDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
