package com.example.BloggingAPI.controller;

import com.example.BloggingAPI.model.User;
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
    public ResponseEntity<String> addUser(@Valid @RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("New User Added",HttpStatus.CREATED);
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<User> getUserById(@RequestParam("userId")int userId){
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.CREATED);
    }

    @GetMapping("/get-user-by-name")
    public ResponseEntity<User> getUserByName(@RequestParam("userName")String userName){
        return new ResponseEntity<>(userService.getUserByName(userName),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-user-by-id")
    public ResponseEntity<String> deleteUser(@RequestParam("userId")int userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.CREATED);
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody User user, @PathVariable int userId){
        userService.updateUser(user,userId);
        return new ResponseEntity<>("User updated.",HttpStatus.CREATED);
    }
}
