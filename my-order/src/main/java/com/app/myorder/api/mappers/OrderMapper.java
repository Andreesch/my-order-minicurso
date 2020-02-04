package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.CreateProductResponseDto;
import com.app.myorder.api.dtos.OrderCreationResponseDto;
import com.app.myorder.entities.Order;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.modelmapper.ModelMapper;

public class OrderMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private OrderMapper() {

    };

    public static OrderCreationResponseDto toResponseDto(Order order) {
        return modelMapper.map(order, OrderCreationResponseDto.class);
    }

}
