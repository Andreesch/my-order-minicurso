package com.app.myorder.api.dtos.user;

import java.util.List;

public class UserResponseListDto {
    private List<UserResponseDto> users;

    public List<UserResponseDto> getUsers() {
        return users;
    }

    public UserResponseListDto setUsers(List<UserResponseDto> users) {
        this.users = users;
        return this;
    }
}
