package com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO;

import jakarta.validation.constraints.NotNull;

public class ForgotPasswordDTO {

    @NotNull(message = "Email is required")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
