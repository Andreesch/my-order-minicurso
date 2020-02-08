package com.app.myorder.api.controllers;

import com.app.myorder.api.dtos.product.CreateProductDto;
import com.app.myorder.api.dtos.product.ProductResponseDto;
import com.app.myorder.api.dtos.product.ProductResponseListDto;
import com.app.myorder.api.mappers.ProductMapper;
import com.app.myorder.services.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("ProductController")
@RequestMapping(RestPath.BASE_PATH + "/product")
@Api(tags = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.product.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Criado com sucesso", response = ProductResponseDto.class),
            @ApiResponse(code = 404, message = "Rest path não encontrado")
    })
    public ProductResponseDto create(
            @ApiParam(value = "${v1.product}", required = true) @RequestBody @Valid CreateProductDto createProductDto) {
        return ProductMapper
                .toResponseDto(productService.create(createProductDto));
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "${v1.product.list}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso", response = ProductResponseListDto.class)
    })
    public ProductResponseListDto list() {
        return ProductMapper.toProductResponseListDto(productService.listAll());
    }

}
