package com.wishalpha.priyanshu.TaskManagementSystem.mapper;

import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.userType.UserTypeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.userType.UserTypeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.entities.UserType;

public class UserTypeMapper {
    public static UserTypeResponseDTO toDto(UserType userType){
        UserTypeResponseDTO userTypeResponseDTO = new UserTypeResponseDTO();
        userTypeResponseDTO.setId(userType.getId().toString());
        userTypeResponseDTO.setName(userType.getName());
        userTypeResponseDTO.setAlias(userType.getAlias());
        userTypeResponseDTO.setDescription(userType.getDescription());
        return userTypeResponseDTO;
    }

    public static UserType toModel(UserTypeRequestDTO userTypeRequestDTO){
        UserType userType = new UserType();
        userType.setName(userTypeRequestDTO.getName());
        userType.setAlias(userTypeRequestDTO.getAlias());
        userType.setDescription(userTypeRequestDTO.getDescription());
        return userType;
    }
}
