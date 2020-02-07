package com.app.myorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.myorder.api.dtos.CreateRestaurantDto;
import com.app.myorder.api.dtos.UpdateRestaurantDto;
import com.app.myorder.config.Translator;
import com.app.myorder.entities.Restaurant;
import com.app.myorder.exceptions.NotFoundException;
import com.app.myorder.repositories.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void createRestaurant(CreateRestaurantDto createRestaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(createRestaurantDto.getName());
        restaurant.setEmail(createRestaurantDto.getEmail());
        restaurant.setPhone(createRestaurantDto.getPhone());
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(UpdateRestaurantDto updateRestaurantDto) {
        Restaurant restaurant = findRestaurantById(updateRestaurantDto.getId());

        if (restaurant != null) {
            restaurant.setName(updateRestaurantDto.getName());
            restaurant.setEmail(updateRestaurantDto.getEmail());
            restaurant.setPhone(updateRestaurantDto.getPhone());
            restaurantRepository.save(restaurant);
        }
    }

    public Restaurant findRestaurantById(Integer id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("restaurant.notfound.exception", new Integer[]{id})));
    }
}
