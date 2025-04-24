package com.wishalpha.priyanshu.TaskManagementSystem.controllers;

import com.wishalpha.priyanshu.TaskManagementSystem.dto.employee.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dto.employee.EmployeeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeRequestDTO> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        System.out.println(employeeRequestDTO+"employee Request DTO");
        EmployeeRequestDTO createEmployeeDto =  this.employeeService.createEmployee(employeeRequestDTO);
        return new ResponseEntity<>(createEmployeeDto, HttpStatus.CREATED);
    }
}
