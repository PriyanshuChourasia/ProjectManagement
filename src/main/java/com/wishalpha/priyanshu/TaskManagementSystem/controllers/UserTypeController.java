package com.wishalpha.priyanshu.TaskManagementSystem.controllers;


import com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.userType.UserTypeRequestDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.dtos.responseDTO.userType.UserTypeResponseDTO;
import com.wishalpha.priyanshu.TaskManagementSystem.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user_type")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;


    @GetMapping("")
    public ResponseEntity<Object> getAll(){
        List<UserTypeResponseDTO> userTypeResponseDTOS = userTypeService.getAll();
        Map<String,Object> resObj = new HashMap<>();
        resObj.put("data",userTypeResponseDTOS);
        resObj.put("success",true);
        return ResponseEntity.ok().body(resObj);
    }

    @PostMapping("")
    public ResponseEntity<Object> createUserType(@RequestBody UserTypeRequestDTO userTypeRequestDTO){
        UserTypeResponseDTO userTypeResponseDTO = userTypeService.create(userTypeRequestDTO);
        Map<String,Object> resobj = new HashMap<>();
        resobj.put("data",userTypeResponseDTO);
        resobj.put("success",true);
        return new ResponseEntity<>(resobj, HttpStatus.CREATED);
    }
}
