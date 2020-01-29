package com.app.myorder.api.controllers;

import com.app.myorder.api.dtos.CreateProductDto;
import com.app.myorder.services.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("ProductController")
@RequestMapping(RestPath.BASE_PATH + "/products")
@Api(tags = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //TODO: Criar serviço de criação de produto
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.product.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Criado com sucesso", response = CreateProductResponseDto.class),
            @ApiResponse(code = 404, message = "Rest path não encontrado")
    })
    public CreateProductResponseDto create(
            @ApiParam(value = "${v1.product}", required = true) @RequestBody @Valid CreateProductDto createProductDto) {
        return null;
    }

}
