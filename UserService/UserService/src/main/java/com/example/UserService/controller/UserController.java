package com.example.UserService.controller;

import com.example.UserService.model.User;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/get/user/{userid}")
    public User getUserinfo(@PathVariable("userid") String userId)
    {
        return userService.getUserById(Integer.parseInt(userId));
    }

}
