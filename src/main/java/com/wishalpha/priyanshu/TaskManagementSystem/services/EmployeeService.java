package com.wishalpha.priyanshu.TaskManagementSystem.services;

import com.wishalpha.priyanshu.TaskManagementSystem.dto.employee.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dto.employee.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeRequestDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO updateEmployee(EmployeeResponseDTO employeeResponseDTO, Long id);
    EmployeeResponseDTO getEmployeeById(EmployeeResponseDTO employeeResponseDTO, Long id);
    List<EmployeeResponseDTO> getAllEmmployees();

    void destroyEmployee(Long id);
}
