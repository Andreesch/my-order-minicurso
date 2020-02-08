package com.app.myorder.api.dtos.restaurant;

import java.util.List;

public class RestaurantResponseListDto {
    private List<RestaurantResponseDto> restaurants;

    public List<RestaurantResponseDto> getRestaurants() {
        return restaurants;
    }

    public RestaurantResponseListDto setRestaurants(List<RestaurantResponseDto> restaurants) {
        this.restaurants = restaurants;
        return this;
    }
}
