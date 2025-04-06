package com.wishalpha.priyanshu.TaskManagementSystem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Users",description = "This is users api")
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String index()
    {
        return "All users returned";
    }
}
