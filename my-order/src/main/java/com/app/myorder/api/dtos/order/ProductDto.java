package com.app.myorder.api.dtos.order;

public class ProductDto {

    private Integer id;

    private String name;

    private Double value;

    public Integer getId() {
        return id;
    }

    public ProductDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProductDto setValue(Double value) {
        this.value = value;
        return this;
    }
}
