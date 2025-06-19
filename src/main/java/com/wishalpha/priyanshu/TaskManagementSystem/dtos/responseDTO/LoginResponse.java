package com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO;

public class LoginResponse {
    private String jwtToken;

    private String email;

    public LoginResponse(String email, String jwtToken){
        this.email = email;
        this.jwtToken = jwtToken;
    }

    public String getEmail(){
        return email;
    }

    public String getJwtToken(){
        return jwtToken;
    }
    public void setEmail(){
        this.email = email;
    }

    public void setJwtToken(){
        this.jwtToken = jwtToken;
    }

}
