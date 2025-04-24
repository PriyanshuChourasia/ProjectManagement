package com.wishalpha.priyanshu.TaskManagementSystem.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeRequestDTO {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 45, message = "Invalid Name: Name must be of 3 - 45 characters")
    private String name;

    @Email(message = "Invalid email")
    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6 , message = "Invalid Password: Password must be greater than 6 characters")
    private String password;


    private String phoneNumber;
}
