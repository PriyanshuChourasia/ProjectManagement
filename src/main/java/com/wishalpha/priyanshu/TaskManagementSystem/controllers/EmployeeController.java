package com.wishalpha.priyanshu.TaskManagementSystem.controllers;


import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.EmployeeUpdateRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.EmployeeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.exceptions.EmailNotSendException;
import com.wishalpha.priyanshu.TaskManagementSystem.services.EmailService;
import com.wishalpha.priyanshu.TaskManagementSystem.services.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    @Autowired
    private EmailService emailService;

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
        String templatePath = "emails/welcome-email";
        String subject = "Welcome To WishAlpha Services";
        Context context = new Context();
        context.setVariable("subject","Welcome To WishAlpha");
        context.setVariable("name",employeeResponseDTO.getName());
        try{
            emailService.sendEmail(employeeResponseDTO.getEmail(),subject,context,templatePath);
        } catch (Exception e) {
            throw new EmailNotSendException("Welcome email not sent");
        }

        return ResponseEntity.ok().body(empRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getById(@PathVariable UUID id){
        EmployeeResponseDTO employeeResponseDTO = employeeService.getById(id);
        return ResponseEntity.ok().body(employeeResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@RequestBody EmployeeUpdateRequestDTO employeeUpdateRequestDTO, @PathVariable UUID id){
        EmployeeResponseDTO employeeResponseDTO = employeeService.update(employeeUpdateRequestDTO,id);
        return ResponseEntity.ok().body(employeeResponseDTO);
    }


}
