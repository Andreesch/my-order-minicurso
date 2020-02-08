package com.app.myorder.api.dtos.product;

import java.util.List;

public class ProductResponseListDto {
    private List<ProductResponseDto> products;

    public List<ProductResponseDto> getProducts() {
        return products;
    }

    public ProductResponseListDto setProducts(List<ProductResponseDto> products) {
        this.products = products;
        return this;
    }
}
