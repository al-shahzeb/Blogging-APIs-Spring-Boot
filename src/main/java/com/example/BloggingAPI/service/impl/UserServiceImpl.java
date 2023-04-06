package com.example.BloggingAPI.service.impl;

import com.example.BloggingAPI.dto.UserDto;
import com.example.BloggingAPI.exception.ResourceNotFoundException;
import com.example.BloggingAPI.model.User;
import com.example.BloggingAPI.repository.UserRepository;
import com.example.BloggingAPI.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        User userr = userRepository.save(user);
        return modelMapper.map(userr,UserDto.class);
    }

    @Override
    public UserDto getUserById(int userId) {
        User use = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User"," id ",userId));
        return modelMapper.map(use,UserDto.class);
    }

    @Override
    public UserDto getUserByName(String userName) {
        List<User> userList = userRepository.findAll();
        for(User user: userList){
            if(user.getUserName().equals(userName))
                return modelMapper.map(user,UserDto.class);
        }
        throw new ResourceNotFoundException("User"," userName "+userName,0);
    }

    @Override
    public void updateUser(UserDto userDto, int userId) {
        User user = modelMapper.map(userDto,User.class);
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
        User user = modelMapper.map(this.getUserById(userId),User.class);
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user: userList)
            userDtoList.add(modelMapper.map(user,UserDto.class));
        return userDtoList;
    }

}
