package com.wishalpha.priyanshu.TaskManagementSystem.mapper;

import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.EmployeeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.entities.Employee;

public class EmployeeMapper {
    public static EmployeeResponseDTO toDto(Employee employee){
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getId().toString());
        employeeResponseDTO.setName(employee.getName());
        employeeResponseDTO.setEmployeeId(employee.getEmployeeId());
        employeeResponseDTO.setEmail(employee.getEmail());
        employeeResponseDTO.setUserType(employee.getUserType());
        return employeeResponseDTO;
    }

    public static Employee toModel(EmployeeRequestDTO employeeRequestDTO){
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setPassword(employeeRequestDTO.getPassword());
        employee.setEmail(employeeRequestDTO.getEmail());
        return employee;
    }
}
