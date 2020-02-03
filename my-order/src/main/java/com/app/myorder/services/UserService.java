package com.app.myorder.services;

import com.app.myorder.api.dtos.CreateUserDto;
import com.app.myorder.api.mappers.UserMapper;
import com.app.myorder.entities.User;
import com.app.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDto createUserDto) {
        User user = UserMapper.toEntity(createUserDto);

        return userRepository.save(user);
    }

    public User findUserById(Integer userId) {
//        return userRepository.findById(userId);
        return null;
    }
}
