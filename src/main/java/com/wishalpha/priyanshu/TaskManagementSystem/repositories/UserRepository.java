package com.wishalpha.priyanshu.TaskManagementSystem.repositories;

import com.wishalpha.priyanshu.TaskManagementSystem.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
}
