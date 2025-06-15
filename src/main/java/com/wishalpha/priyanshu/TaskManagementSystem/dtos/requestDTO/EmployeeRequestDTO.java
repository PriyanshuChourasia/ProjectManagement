package com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDTO {

    @NotNull(message = "Name is required")
    @Size(max = 100, message = "Name cannot be more than 100 characters")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Email is Invalid")
    private String email;

    @NotNull()
    @Size(min = 8, message = "Password cannot be less than 8 characters")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
