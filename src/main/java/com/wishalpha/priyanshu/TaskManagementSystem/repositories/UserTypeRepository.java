package com.wishalpha.priyanshu.TaskManagementSystem.repositories;

import com.wishalpha.priyanshu.TaskManagementSystem.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserTypeRepository extends JpaRepository<UserType, UUID> {
    boolean existsById(UUID id);

    boolean existsByName(String name);
}
