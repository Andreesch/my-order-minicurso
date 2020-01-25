package com.app.myorder.api.controllers;

import com.app.myorder.api.dtos.CreateRestaurantDto;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("RestaurantControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/restaurant")
@Api(tags = "Restaurants")
public class RestaurantController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

    //@Autowired
    //private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.restaurant.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Sucesso", response = CreateRestaurantDto.class)
    })
    public CreateRestaurantDto create(
            @ApiParam(value = "${v1.restaurant}", required = true) @RequestBody @Valid CreateRestaurantDto createUserDto) {
        //TODO

        return new CreateRestaurantDto();
    }
}
