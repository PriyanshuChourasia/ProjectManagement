package com.wishalpha.priyanshu.TaskManagementSystem.services;

import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.EmployeeResponseDTO;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<EmployeeResponseDTO> getAll();
    EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO getById(UUID id);
}
