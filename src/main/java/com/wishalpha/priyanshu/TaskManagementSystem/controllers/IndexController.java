package com.wishalpha.priyanshu.TaskManagementSystem.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index(HttpServletRequest request)
    {
        return "Welcome To Spring Boot java ," + request.getSession().getId();
    }
}
