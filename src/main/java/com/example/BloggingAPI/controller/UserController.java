package com.example.BloggingAPI.controller;

import com.example.BloggingAPI.dto.UserDto;
import com.example.BloggingAPI.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users-api")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @PostMapping("/add-user")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto user){

        return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<UserDto> getUserById(@RequestParam("userId")int userId){
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.CREATED);
    }

    @GetMapping("/get-user-by-name")
    public ResponseEntity<UserDto> getUserByName(@RequestParam("userName")String userName){
        return new ResponseEntity<>(userService.getUserByName(userName),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-user-by-id")
    public ResponseEntity<String> deleteUser(@RequestParam("userId")int userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.CREATED);
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody UserDto user, @PathVariable int userId){
        userService.updateUser(user,userId);
        return new ResponseEntity<>("User updated.",HttpStatus.CREATED);
    }
}
