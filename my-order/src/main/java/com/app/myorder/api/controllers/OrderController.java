package com.app.myorder.api.controllers;

import com.app.myorder.api.dtos.order.OrderCreationDto;
import com.app.myorder.api.dtos.order.OrderResponseDto;
import com.app.myorder.api.dtos.order.OrderResponseListDto;
import com.app.myorder.api.dtos.restaurant.RestaurantResponseDto;
import com.app.myorder.api.mappers.OrderMapper;
import com.app.myorder.services.OrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("OrderController")
@RequestMapping(RestPath.BASE_PATH + "/order")
@Api(tags = "Orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.order.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Criado com sucesso", response = OrderResponseDto.class),
            @ApiResponse(code = 404, message = "Rest path não encontrado")
    })
    public OrderResponseDto create(
            @ApiParam(value = "${v1.order}", required = true) @RequestBody @Valid OrderCreationDto orderCreationDto) {
        return OrderMapper.toResponseDto(orderService.create(orderCreationDto));
    }

    @GetMapping(value = "/find")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "${v1.order.find}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso", response = RestaurantResponseDto.class)
    })
    public OrderResponseDto findById(
            @ApiParam(value = "${v1.order.code}", required = true) @RequestParam("code") Integer code) {
        return OrderMapper.toFindResponseDto(orderService.find(code));
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "${v1.order.list}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso", response = OrderResponseListDto.class)
    })
    public OrderResponseListDto list() {
        return OrderMapper.toOrderResponseListDto(
                orderService.listAll());
    }

}
