package com.example.BloggingAPI.service;

import com.example.BloggingAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void addUser(User user);
    User getUserById(int userId);
    User getUserByName(String userName);
    void updateUser(User user, int userId);
    void deleteUser(int userId);
    List<User> getAllUsers();


}
