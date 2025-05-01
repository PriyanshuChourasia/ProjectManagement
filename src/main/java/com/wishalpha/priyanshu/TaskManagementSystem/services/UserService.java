package com.wishalpha.priyanshu.TaskManagementSystem.services;


import com.wishalpha.priyanshu.TaskManagementSystem.entities.MyUser;

import java.util.List;

public interface UserService {
    MyUser registerUser(MyUser user);
    String authenticateUser(MyUser user);
    MyUser userDetails();
    List<MyUser> getAllUsers();
}
