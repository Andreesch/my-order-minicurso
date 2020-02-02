package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.CreateUserDto;
import com.app.myorder.api.dtos.CreateUserResponseDto;
import com.app.myorder.entities.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private UserMapper(){
    };

    public static User toEntity(CreateUserDto createUserDto) {
        return modelMapper.map(createUserDto, User.class);
    }

    public static CreateUserResponseDto toResponseDto(User user) {
        return modelMapper.map(user, CreateUserResponseDto.class);
    }
}
