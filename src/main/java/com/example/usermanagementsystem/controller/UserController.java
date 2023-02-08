package com.example.usermanagementsystem.controller;

import com.example.usermanagementsystem.model.UserModel;
import com.example.usermanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-app")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService=userService;
    }


    @PostMapping("/add-user")
    public void addTodo(@RequestBody UserModel users) {
        userService.addUser(users);
    }


    @GetMapping("/find-user/userId/{userId}")

    public UserModel findUserById(@PathVariable int userId) {
        return userService.findByUserId(userId);
    }


    @GetMapping("find-all")
    public List<UserModel> findAllUsers() { // controller is talking to the service layer
        return userService.findAll();
    }


    @PutMapping("update-user/userId/{userId}")
    public void updateUser(@PathVariable int userId,@RequestBody UserModel user) {
        userService.updateUser(userId,user);
    }


    @DeleteMapping("delete-user/userId/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
