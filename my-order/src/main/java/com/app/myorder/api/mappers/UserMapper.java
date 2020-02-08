package com.app.myorder.api.mappers;

import com.app.myorder.api.dtos.user.UserCreateDto;
import com.app.myorder.api.dtos.user.UserResponseDto;
import com.app.myorder.api.dtos.user.UserResponseListDto;
import com.app.myorder.api.dtos.user.UserUpdateDto;
import com.app.myorder.entities.User;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private UserMapper(){
    };

    public static User toEntity(UserCreateDto userCreateDto) {
        return modelMapper.map(userCreateDto, User.class);
    }

    public static User toEntity(UserUpdateDto userCreateDto) {
        return modelMapper.map(userCreateDto, User.class);
    }

    public static UserResponseDto toResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    public static UserResponseListDto toUserResponseListDto(List<User> user) {
        return new UserResponseListDto()
                .setUsers(user.stream()
                        .map(UserMapper::toResponseDto)
                        .collect(Collectors.toList()));
    }
}
