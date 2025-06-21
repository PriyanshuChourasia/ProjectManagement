package com.wishalpha.priyanshu.TaskManagementSystem.controllers;


import com.wishalpha.priyanshu.TaskManagementSystem.config.jwt.JwtUtils;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.ForgotPasswordDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.LoginRequest;
import com.wishalpha.priyanshu.TaskManagementSystem.entities.Employee;
import com.wishalpha.priyanshu.TaskManagementSystem.repositories.EmployeeRepository;
import com.wishalpha.priyanshu.TaskManagementSystem.services.EmailService;
import com.wishalpha.priyanshu.TaskManagementSystem.services.impl.RedisService;
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
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RedisService redisService;

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

    @PostMapping("/forgot-password")
    public ResponseEntity<Object> forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO){
        try {
            if (!employeeRepository.existsByEmail(forgotPasswordDTO.getEmail())){
                Map<String,Object> map = new HashMap<>();
                Map<String,String> res = new HashMap<>();

                res.put("message","Email doesn't exists");
                map.put("errors",res);
                map.put("success",false);
                return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
            }

            Employee employee = employeeRepository.findByEmail(forgotPasswordDTO.getEmail());
            Random random = new Random();
            int otp = random.nextInt(9000) + 1000;
            redisService.setKeyWithTTl("otp_key",String.valueOf(otp),160);
            String templatePath = "emails/forgot-password";
            String subject = "Forgot password";
            Context  context = new Context();
            context.setVariable("subject","Forgot Password");
            context.setVariable("name", employee.getName());
            context.setVariable("otp",otp);
            emailService.sendEmail(forgotPasswordDTO.getEmail(),subject,context,templatePath);

            Map<String,Object> res = new HashMap<>();
            Map<String,String> map = new HashMap<>();

            map.put("message","An Otp has been sent to registered mail");
            res.put("data",map);
            res.put("success",true);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }catch (Exception e){
            logger.error("Forgot Password Error: {}",e.getMessage());
            Map<String,Object> map = new HashMap<>();
            Map<String,String> res = new HashMap<>();

            res.put("message","Data Error");
            map.put("errors",res);
            map.put("success",false);
            return  ResponseEntity.badRequest().body(map);
        }
    }
}
