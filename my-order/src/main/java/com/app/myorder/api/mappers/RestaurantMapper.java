package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.RestaurantFindResponseDto;
import com.app.myorder.entities.Restaurant;
import org.modelmapper.ModelMapper;

public class RestaurantMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private RestaurantMapper(){

    };

    public static RestaurantFindResponseDto toFindResponseDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantFindResponseDto.class);
    }

}
