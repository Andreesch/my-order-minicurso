package com.app.myorder.api.controllers;

import com.app.myorder.api.dtos.CreateUserDto;
import com.app.myorder.api.dtos.CreateUserResponseDto;
import com.app.myorder.api.mappers.UserMapper;
import com.app.myorder.services.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
            @ApiResponse(code = 201, message = "Criado com sucesso", response = CreateUserResponseDto.class),
            @ApiResponse(code = 404, message = "Rest path não encontrado")
    })
    public CreateUserResponseDto create(
            @ApiParam(value = "${v1.user}", required = true) @RequestBody @Valid CreateUserDto createUserDto) {
        return UserMapper.toResponseDto(userService.createUser(createUserDto));
    }
}
