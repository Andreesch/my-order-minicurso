package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.restaurant.RestaurantResponseDto;
import com.app.myorder.api.dtos.restaurant.RestaurantResponseListDto;
import com.app.myorder.entities.Restaurant;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private RestaurantMapper(){

    };

    public static RestaurantResponseListDto toRestaurantListDto(List<Restaurant> restaurants) {
        return new RestaurantResponseListDto()
                .setRestaurants(restaurants.stream()
                        .map(RestaurantMapper::toRestaurantResponseDto)
                        .collect(Collectors.toList()));
    }

    public static RestaurantResponseDto toRestaurantResponseDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantResponseDto.class);
    }
}
