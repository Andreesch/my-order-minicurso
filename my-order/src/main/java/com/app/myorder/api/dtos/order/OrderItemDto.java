package com.app.myorder.api.dtos.order;

public class OrderItemDto {

    private Integer id;

    private Integer quantity;

    private ProductDto product;

    public Integer getId() {
        return id;
    }

    public OrderItemDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductDto getProduct() {
        return product;
    }

    public OrderItemDto setProduct(ProductDto product) {
        this.product = product;
        return this;
    }
}
