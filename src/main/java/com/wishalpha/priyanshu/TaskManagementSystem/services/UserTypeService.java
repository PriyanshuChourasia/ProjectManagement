package com.wishalpha.priyanshu.TaskManagementSystem.services;

import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.userType.UserTypeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.userType.UserTypeResponseDTO;

import java.util.List;

public interface UserTypeService {

    List<UserTypeResponseDTO> getAll();

    UserTypeResponseDTO create(UserTypeRequestDTO userTypeRequestDTO);
}
