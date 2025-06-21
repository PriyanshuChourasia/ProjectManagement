package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;


import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.userType.UserTypeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.userType.UserTypeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.entities.UserType;
import com.wishalpha.priyanshu.TaskManagementSystem.exceptions.DataExistsException;
import com.wishalpha.priyanshu.TaskManagementSystem.mapper.UserTypeMapper;
import com.wishalpha.priyanshu.TaskManagementSystem.repositories.UserTypeRepository;
import com.wishalpha.priyanshu.TaskManagementSystem.services.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository){
        this.userTypeRepository = userTypeRepository;
    }


    @Override
    public List<UserTypeResponseDTO> getAll(){
        List<UserType> userTypes = userTypeRepository.findAll();
        List<UserTypeResponseDTO> userTypeResponseDTOS = userTypes.stream().map(userType -> UserTypeMapper.toDto(userType)).toList();
        return userTypeResponseDTOS;
    }

    @Override
    public UserTypeResponseDTO create(UserTypeRequestDTO userTypeRequestDTO){

        if(userTypeRepository.existsByName(userTypeRequestDTO.getName())){
            throw new DataExistsException("User type exists");
        }
        UserType userType = userTypeRepository.save(UserTypeMapper.toModel(userTypeRequestDTO));
        return UserTypeMapper.toDto(userType);
    }
}
