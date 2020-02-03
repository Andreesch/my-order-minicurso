package com.app.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

public class CreateProductResponseDto {

    @ApiModelProperty(value = "${product.create.id}")
    private Integer id;

    @ApiModelProperty(value = "${product.create.name}")
    private String name;

    @ApiModelProperty(value = "${product.create.description}")
    private String description;

    @ApiModelProperty(value = "${product.create.value}")
    private Double value;

    public Integer getId() {
        return id;
    }

    public CreateProductResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateProductResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateProductResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CreateProductResponseDto setValue(Double value) {
        this.value = value;
        return this;
    }
}
