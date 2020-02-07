package com.app.myorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.myorder.api.dtos.CreateUserDto;
import com.app.myorder.api.mappers.UserMapper;
import com.app.myorder.config.Translator;
import com.app.myorder.entities.User;
import com.app.myorder.exceptions.NotFoundException;
import com.app.myorder.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDto createUserDto) {
        User user = UserMapper.toEntity(createUserDto);

        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("user.notfound.exception", new Integer[]{id})));
    }
}
