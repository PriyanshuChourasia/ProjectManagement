package com.wishalpha.priyanshu.TaskManagementSystem.controllers;


import com.wishalpha.priyanshu.TaskManagementSystem.config.jwt.JwtUtils;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.LoginRequest;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);
            String jwtRefreshToken = jwtUtils.generateRefreshToken(userDetails);

            Map<String,Object> res = new HashMap<>();
            Map<String,String> tokens = new HashMap<>();
            tokens.put("access_token",jwtToken);
            tokens.put("refresh_token",jwtRefreshToken);
            res.put("data",tokens);
            res.put("success",true);
            return ResponseEntity.ok().body(res);
        } catch (AuthenticationException e) {
            logger.error("Authentication failed: {}", e.getMessage());
            Map<String, Object> map = new HashMap<>();
            Map<String,String> error = new HashMap<>();
            error.put("message","Bad Credentials");
            map.put("errors",error);
            map.put("status",false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

    }
}
