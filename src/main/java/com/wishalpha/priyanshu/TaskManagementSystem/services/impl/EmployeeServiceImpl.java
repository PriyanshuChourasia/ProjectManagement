package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;

import com.wishalpha.priyanshu.TaskManagementSystem.dto.employee.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dto.employee.EmployeeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.entities.Employee;
import com.wishalpha.priyanshu.TaskManagementSystem.exceptions.ResourceNotFoundException;
import com.wishalpha.priyanshu.TaskManagementSystem.repositories.EmployeeRepository;
import com.wishalpha.priyanshu.TaskManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeRequestDTO createEmployee(EmployeeRequestDTO employeeRequestDTO){
        Employee employee = this.dToEmployee(employeeRequestDTO);
        Employee createdEmployee = this.employeeRepository.save(employee);
        return this.requestEmployeeToDto(createdEmployee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeResponseDTO employeeResponseDTO, Long id) {
        Employee employee = this.employeeRepository
                .findById(id).orElseThrow(() ->  new ResourceNotFoundException("Employee not found" + id));

        employee.setName(employeeResponseDTO.getName());
        employee.setEmail(employeeResponseDTO.getEmail());
        employee.setGender(employeeResponseDTO.getGender());
        employee.setDob(employeeResponseDTO.getDob());
        employee.setAltPhoneNumber(employeeResponseDTO.getAltPhoneNumber());
        employee.setPhoneNumber(employeeResponseDTO.getPhoneNumber());

        Employee updatedEmployee = this.employeeRepository.save(employee);
        EmployeeResponseDTO employeeResponseDTO1 = this.employeeToDto(updatedEmployee);
        return  employeeResponseDTO1;
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(EmployeeResponseDTO employeeResponseDTO, Long id) {

        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"+id));

        return this.employeeToDto(employee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOS = employees.stream().map(employee -> this.employeeToDto(employee)).collect(Collectors.toList());

        return employeeResponseDTOS;
    }

    @Override
    public void destroyEmployee(Long id) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found "+id));
            this.employeeRepository.delete(employee);
    }

    private Employee dToEmployee(EmployeeRequestDTO employeeRequestDTO){
        Employee employee = new Employee();
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setName(employeeRequestDTO.getName());
        employee.setPassword(employeeRequestDTO.getPassword());
        employee.setPhoneNumber(employeeRequestDTO.getPhoneNumber());
        return employee;
    }

    public EmployeeResponseDTO employeeToDto(Employee employee){
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getId());
        employeeResponseDTO.setName(employee.getName());
        employeeResponseDTO.setEmail(employee.getEmail());
        employeeResponseDTO.setAltPhoneNumber(employee.getAltPhoneNumber());
        employeeResponseDTO.setGender(employee.getGender());
        employeeResponseDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeResponseDTO.setDob(employee.getDob());
        employeeResponseDTO.setCreatedAt(employee.getCreatedAt());
        return employeeResponseDTO;
    }

    public EmployeeRequestDTO requestEmployeeToDto(Employee employee){
        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();
        employeeRequestDTO.setName(employee.getName());
        employeeRequestDTO.setEmail(employee.getEmail());
        employeeRequestDTO.setPhoneNumber(employee.getPhoneNumber());
        return employeeRequestDTO;
    }
}
