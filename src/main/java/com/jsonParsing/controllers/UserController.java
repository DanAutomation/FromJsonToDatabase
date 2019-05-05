package com.jsonParsing.controllers;

import com.jsonParsing.domain.User;
import com.jsonParsing.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")  // http://localchost:8080/users
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<User> list(){
        return userService.list();
    }
}
