package com.wishalpha.priyanshu.TaskManagementSystem.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String altPhoneNumber;
    private String gender;
    private LocalDate dob;
    private Instant createdAt;
}
