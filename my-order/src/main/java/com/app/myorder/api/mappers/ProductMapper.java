package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.order.ProductDto;
import com.app.myorder.api.dtos.product.ProductCreateDto;
import com.app.myorder.api.dtos.product.ProductResponseDto;
import com.app.myorder.api.dtos.product.ProductResponseListDto;
import com.app.myorder.api.dtos.product.ProductUpdateDto;
import com.app.myorder.entities.Product;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private ProductMapper(){

    };

    public static Product toEntity(ProductCreateDto productCreateDto) {
        return modelMapper.map(productCreateDto, Product.class);
    }

    public static Product toEntity(ProductUpdateDto productCreateDto) {
        return modelMapper.map(productCreateDto, Product.class);
    }

    public static ProductResponseDto toResponseDto(Product product){
        return modelMapper.map(product, ProductResponseDto.class)
                .setRestaurant(RestaurantMapper.toRestaurantResponseDto(product.getRestaurant()));
    }

    public static ProductDto toProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public static ProductResponseListDto toProductResponseListDto(List<Product> products) {
        return new ProductResponseListDto()
                .setProducts(products.stream()
                        .map(ProductMapper::toResponseDto)
                .collect(Collectors.toList()));
    }
}
