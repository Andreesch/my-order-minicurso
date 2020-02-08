package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.CreateProductDto;
import com.app.myorder.api.dtos.CreateProductResponseDto;
import com.app.myorder.api.dtos.order.ProductDto;
import com.app.myorder.entities.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private ProductMapper(){

    };

    public static Product toEntity(CreateProductDto createProductDto) {
        return modelMapper.map(createProductDto, Product.class);
    }

    public static CreateProductResponseDto toResponseDto(Product product){
        return modelMapper.map(product, CreateProductResponseDto.class);
    }

    public static ProductDto toProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
