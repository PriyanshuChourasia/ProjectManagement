package com.wishalpha.priyanshu.TaskManagementSystem.controllers;


import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.EmployeeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Object> create(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO){
        EmployeeResponseDTO employeeResponseDTO = employeeService.create(employeeRequestDTO);
        Map<String,Object> empRes = new HashMap<>();
        empRes.put("data",employeeResponseDTO);
        empRes.put("message","Employee created successfully");
        empRes.put("success",true);

        return ResponseEntity.ok().body(empRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getById(@PathVariable UUID id){
        EmployeeResponseDTO employeeResponseDTO = employeeService.getById(id);
        return ResponseEntity.ok().body(employeeResponseDTO);
    }


}
