package com.example.BloggingAPI.service;

import com.example.BloggingAPI.dto.UserDto;
import com.example.BloggingAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto addUser(UserDto userDto);
    UserDto getUserById(int userId);
    UserDto getUserByName(String userName);
    void updateUser(UserDto userDto, int userId);
    void deleteUser(int userId);
    List<UserDto> getAllUsers();


}
