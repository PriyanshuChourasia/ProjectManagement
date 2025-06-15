package com.wishalpha.priyanshu.TaskManagementSystem.controllers;


import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.EmployeeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAll(){
        List<EmployeeResponseDTO> employeeResponseDTO = employeeService.getAll();
        return ResponseEntity.ok().body(employeeResponseDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDTO> create(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO){
        EmployeeResponseDTO employeeResponseDTO = employeeService.create(employeeRequestDTO);
        return ResponseEntity.ok().body(employeeResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getById(@PathVariable UUID id){
        EmployeeResponseDTO employeeResponseDTO = employeeService.getById(id);
        return ResponseEntity.ok().body(employeeResponseDTO);
    }
}
