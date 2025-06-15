package com.wishalpha.priyanshu.TaskManagementSystem.repositories;

import com.wishalpha.priyanshu.TaskManagementSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    boolean existsByEmail(String email);

    boolean existsById(UUID id);
}
