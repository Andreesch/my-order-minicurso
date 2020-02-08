package com.app.myorder.api.controllers;

import com.app.myorder.api.dtos.UpdateRestaurantDto;
import com.app.myorder.api.dtos.restaurant.CreateRestaurantDto;
import com.app.myorder.api.dtos.restaurant.RestaurantResponseListDto;
import com.app.myorder.api.mappers.RestaurantMapper;
import com.app.myorder.services.RestaurantService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("RestaurantControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/restaurant")
@Api(tags = "Restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.restaurant.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Sucesso", response = CreateRestaurantDto.class)
    })
    public CreateRestaurantDto create(
            @ApiParam(value = "${v1.restaurant}", required = true) @RequestBody @Valid CreateRestaurantDto createUserDto) {

        restaurantService.createRestaurant(createUserDto);
        return new CreateRestaurantDto();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.restaurant.update}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso")
    })
    public void update(
            @ApiParam(value = "${v1.restaurant}", required = true) @RequestBody @Valid UpdateRestaurantDto updateUserDto) {
        restaurantService.updateRestaurant(updateUserDto);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "${v1.restaurant.list}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso", response = RestaurantResponseListDto.class)
    })
    public RestaurantResponseListDto list() {
        return RestaurantMapper.toRestaurantListDto(restaurantService.listAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping()
    @ApiOperation(value = "${v1.restaurant.delete}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso")
    })
    public void delete(
            @ApiParam(value = "${v1.restaurant}", required = true) @RequestParam @Param("id") Integer id) {
        restaurantService.deleteRestaurant(id);
    }

}
