package com.wishalpha.priyanshu.TaskManagementSystem.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(String username);
    String getJWTUsername(String token);
    boolean validateToken(String token, UserDetails userDetails);
}
