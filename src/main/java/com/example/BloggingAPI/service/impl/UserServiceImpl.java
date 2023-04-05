package com.example.BloggingAPI.service.impl;

import com.example.BloggingAPI.exception.ResourceNotFoundException;
import com.example.BloggingAPI.model.User;
import com.example.BloggingAPI.repository.UserRepository;
import com.example.BloggingAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(int userId) {
        User use = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User"," id ",userId));
        return use;
    }

    @Override
    public User getUserByName(String userName) {
        List<User> userList = userRepository.findAll();
        for(User user: userList){
            if(user.getUserName().equals(userName))
                return user;
        }
        return null;
    }

    @Override
    public void updateUser(User user, int userId) {
        User use =null;
        use = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User"," id ",userId));

        use.setUserId(use.getUserId());
        use.setUserName(user.getUserName());
        use.setEmail(user.getEmail());
        use.setPassword(user.getPassword());
        use.setAbout(user.getAbout());

        userRepository.save(use);
    }

    @Override
    public void deleteUser(int userId) {
        User user = this.getUserById(userId);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
