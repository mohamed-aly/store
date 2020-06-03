package com.vis.store.controller;

import com.vis.store.model.User;
import com.vis.store.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public Set<User> getUser(){
        return userService.findAll();
    }

}
	

	

















