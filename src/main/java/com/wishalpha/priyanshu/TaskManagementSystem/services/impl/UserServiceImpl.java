package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;

import com.wishalpha.priyanshu.TaskManagementSystem.entities.MyUser;
import com.wishalpha.priyanshu.TaskManagementSystem.repositories.UserRepository;
import com.wishalpha.priyanshu.TaskManagementSystem.services.JWTService;
import com.wishalpha.priyanshu.TaskManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Override
    public MyUser registerUser(MyUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String authenticateUser(MyUser user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        System.out.println("authentication" + authentication);
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(user.getUsername());
        }else{
            return "User not logged in";
        }
    }


    @Override
    public MyUser userDetails(){
        return null;
    }
}
