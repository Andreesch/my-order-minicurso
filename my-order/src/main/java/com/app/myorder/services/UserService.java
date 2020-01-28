package com.app.myorder.services;

import com.app.myorder.api.dtos.CreateUserDto;
import com.app.myorder.api.mappers.CreateUserMapper;
import com.app.myorder.entities.User;
import com.app.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDto createUserDto) {
        User user = CreateUserMapper.toEntity(createUserDto);

        return userRepository.save(user);
    }
}
