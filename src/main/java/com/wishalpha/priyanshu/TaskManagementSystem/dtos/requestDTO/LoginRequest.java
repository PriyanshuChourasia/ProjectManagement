package com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO;

public class LoginRequest {
    private String email;
    private String password;

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(){
        this.password = password;
    }
}
