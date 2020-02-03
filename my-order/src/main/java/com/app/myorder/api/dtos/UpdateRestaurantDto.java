package com.app.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateRestaurantDto {

    @NotNull
    @ApiModelProperty(value = "update.restaurant.id")
    private Integer id;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "update.restaurant.name")
    private String name;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "update.restaurant.phone")
    private String phone;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "update.restaurant.email")
    private String email;

    public Integer getId() {
        return id;
    }

    public UpdateRestaurantDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UpdateRestaurantDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UpdateRestaurantDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdateRestaurantDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
