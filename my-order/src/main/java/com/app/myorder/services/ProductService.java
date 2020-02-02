package com.app.myorder.services;

import com.app.myorder.api.dtos.CreateProductDto;
import com.app.myorder.api.mappers.ProductMapper;
import com.app.myorder.entities.Product;
import com.app.myorder.entities.Restaurant;
import com.app.myorder.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestaurantService restaurantService;

    public Product create(CreateProductDto createProductDto) {
        return productRepository.save(
                createProduct(createProductDto));
    }

    private Product createProduct(CreateProductDto createProductDto) {
        return ProductMapper
                .toEntity(createProductDto)
                .setRestaurant(findProductRestaurant(createProductDto.getRestaurantId()));
    }

    private Restaurant findProductRestaurant(Integer restaurantId) {
        return restaurantService.findRestaurantById(restaurantId);
    }
}
