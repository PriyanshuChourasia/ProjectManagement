package com.wishalpha.priyanshu.TaskManagementSystem.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class IndexController {

    @GetMapping
    public ResponseEntity<Object> index(){
        Map<String,String> response = new HashMap<>();

        response.put("message","Welcome to Task Management");
        response.put("status","Success");
        return ResponseEntity.ok().body(response);
    }
}
