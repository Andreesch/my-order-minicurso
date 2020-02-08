package com.app.myorder.services;

import com.app.myorder.api.dtos.user.UserCreateDto;
import com.app.myorder.api.dtos.user.UserUpdateDto;
import com.app.myorder.api.mappers.UserMapper;
import com.app.myorder.config.Translator;
import com.app.myorder.entities.User;
import com.app.myorder.exceptions.NotFoundException;
import com.app.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreateDto userCreateDto) {
        User user = UserMapper.toEntity(userCreateDto);

        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("user.notfound.exception", new Integer[]{id})));
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void updateUser(UserUpdateDto userUpdateDto) {
        findUserById(userUpdateDto.getId());

        userRepository.save(UserMapper.toEntity(userUpdateDto));
    }

    public void deleteUser(Integer userId) {
        userRepository.delete(findUserById(userId));
    }
}
