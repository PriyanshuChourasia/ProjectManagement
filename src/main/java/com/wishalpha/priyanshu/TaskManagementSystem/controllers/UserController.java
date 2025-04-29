package com.wishalpha.priyanshu.TaskManagementSystem.controllers;

import com.wishalpha.priyanshu.TaskManagementSystem.entities.MyUser;
import com.wishalpha.priyanshu.TaskManagementSystem.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="Users",description = "This is users api")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index()
    {
        return "All users returned";
    }


    @PostMapping("/register")
    public MyUser register(@RequestBody MyUser user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody MyUser user){
       return userService.authenticateUser(user);
    }

    @GetMapping("/details")
    public MyUser userDetail(){
        return userService.userDetails();
    }
}
