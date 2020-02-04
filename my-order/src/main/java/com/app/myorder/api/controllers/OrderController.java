package com.app.myorder.api.controllers;

import com.app.myorder.api.dtos.OrderCreationDto;
import com.app.myorder.api.dtos.OrderCreationResponseDto;
import com.app.myorder.api.mappers.OrderMapper;
import com.app.myorder.services.OrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("OrderController")
@RequestMapping(RestPath.BASE_PATH + "/orders")
@Api(tags = "Orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.order.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Criado com sucesso", response = OrderCreationResponseDto.class),
            @ApiResponse(code = 404, message = "Rest path não encontrado")
    })
    public OrderCreationResponseDto create(
            @ApiParam(value = "${v1.order}", required = true) @RequestBody @Valid OrderCreationDto orderCreationDto) {
        return OrderMapper
                .toResponseDto(orderService.create(orderCreationDto));
    }

}
