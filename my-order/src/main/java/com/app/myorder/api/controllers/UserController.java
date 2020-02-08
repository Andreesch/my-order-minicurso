package com.app.myorder.api.controllers;

import com.app.myorder.api.dtos.restaurant.RestaurantResponseListDto;
import com.app.myorder.api.dtos.user.UserCreateDto;
import com.app.myorder.api.dtos.user.UserResponseDto;
import com.app.myorder.api.dtos.user.UserResponseListDto;
import com.app.myorder.api.dtos.user.UserUpdateDto;
import com.app.myorder.api.mappers.UserMapper;
import com.app.myorder.services.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("UserController")
@RequestMapping(RestPath.BASE_PATH + "/users")
@Api(tags = "Users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.user.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Criado com sucesso", response = UserResponseDto.class),
            @ApiResponse(code = 404, message = "Rest path não encontrado")
    })
    public UserResponseDto create(
            @ApiParam(value = "${v1.user}", required = true) @RequestBody @Valid UserCreateDto userCreateDto) {
        return UserMapper.toResponseDto(userService.createUser(userCreateDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.user.update}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso")
    })
    public void update(
            @ApiParam(value = "${v1.user}", required = true) @RequestBody @Valid UserUpdateDto userUpdateDto) {
        userService.updateUser(userUpdateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping()
    @ApiOperation(value = "${v1.user.delete}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso")
    })
    public void delete(
            @ApiParam(value = "${v1.user.id}", required = true) @RequestParam @Param("id") Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "${v1.user.list}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso", response = RestaurantResponseListDto.class)
    })
    public UserResponseListDto list() {
        return UserMapper.toUserResponseListDto(userService.listAll());
    }


}
