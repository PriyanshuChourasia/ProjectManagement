package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;


import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.EmployeeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.EmployeeUpdateRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.EmployeeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.entities.Employee;
import com.wishalpha.priyanshu.TaskManagementSystem.exceptions.DataExistsException;
import com.wishalpha.priyanshu.TaskManagementSystem.exceptions.DataNotExistsException;
import com.wishalpha.priyanshu.TaskManagementSystem.mapper.EmployeeMapper;
import com.wishalpha.priyanshu.TaskManagementSystem.repositories.EmployeeRepository;
import com.wishalpha.priyanshu.TaskManagementSystem.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeResponseDTO> getAll(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOS = employees.stream().map(employee -> EmployeeMapper.toDto(employee)).toList();
        return employeeResponseDTOS;
    }

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO){
        Employee employee = new Employee();
        if(employeeRepository.existsByEmail(employeeRequestDTO.getEmail())){
            throw new DataExistsException("Employee exists by this email");
        }
        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setPassword(passwordEncoder.encode(employeeRequestDTO.getPassword()));
        Employee createdUser = employeeRepository.save(employee);
        return EmployeeMapper.toDto(createdUser);
    }


    @Override
    public EmployeeResponseDTO getById(UUID id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new DataNotExistsException("Employee not found with this id"));
        return EmployeeMapper.toDto(employee);
    }

    @Override
    public EmployeeResponseDTO update(EmployeeUpdateRequestDTO employeeUpdateRequestDTO, UUID id){
        try{
            Employee employee = employeeRepository.findById(id).orElseThrow(()-> new DataNotExistsException("Employee does not exists"));
            if(employeeUpdateRequestDTO.getName() != null && !employeeUpdateRequestDTO.getName().isEmpty()){
                employee.setName(employeeUpdateRequestDTO.getName());
            }
            if(employeeUpdateRequestDTO.getAddress() != null && !employeeUpdateRequestDTO.getAddress().isEmpty()){
                employee.setAddress(employeeUpdateRequestDTO.getAddress());
            }
            if(employeeUpdateRequestDTO.getPhoneNumber() != null){
                employee.setPhoneNumber(employeeUpdateRequestDTO.getPhoneNumber());
            }
            if(employeeUpdateRequestDTO.getAltPhoneNumber() != null){
                employee.setAltPhoneNumber(employeeUpdateRequestDTO.getAltPhoneNumber());
            }
            Employee updatedEmployee = employeeRepository.save(employee);
            return EmployeeMapper.toDto(updatedEmployee);
        }catch (Exception e){
            throw new DataNotExistsException(e.getMessage());
        }
    }
}
