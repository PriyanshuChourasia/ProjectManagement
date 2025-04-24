package com.wishalpha.priyanshu.TaskManagementSystem.repositories;

import com.wishalpha.priyanshu.TaskManagementSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
