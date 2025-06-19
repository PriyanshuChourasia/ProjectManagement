package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;

import com.wishalpha.priyanshu.TaskManagementSystem.entities.Employee;
import com.wishalpha.priyanshu.TaskManagementSystem.entities.UserPrincipal;
import com.wishalpha.priyanshu.TaskManagementSystem.exceptions.DataNotExistsException;
import com.wishalpha.priyanshu.TaskManagementSystem.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws DataNotExistsException {

        Employee employee = employeeRepository.findByEmail(email);


        if(employee == null){
            logger.error("Employee not found");
            throw new DataNotExistsException("Employee not found");
        }

        return new UserPrincipal(employee);
    }
}
