package com.wishalpha.priyanshu.TaskManagementSystem.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error-> erros.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(DataNotExistsException.class)
    public ResponseEntity<Object> handleDataNotValidException(DataNotExistsException ex){
        Map<String,Object> res = new HashMap<>();
        Map<String,String> errorMessage = new HashMap<>();

        errorMessage.put("message",ex.getMessage());
        res.put("errors", errorMessage);
        res.put("success",false);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DataExistsException.class)
    public ResponseEntity<Object> handleDataExistsValidation(DataExistsException ex){
        Map<String,Object> res = new HashMap<>();
        Map<String,String> errorMessage = new HashMap<>();

        errorMessage.put("message",ex.getMessage());
        res.put("errors",errorMessage);
        res.put("success",false);
        return new ResponseEntity<>(res,HttpStatus.FOUND);
    }

//    Data integrity violation errors

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityExceptionViolation(DataIntegrityViolationException ex){
        Map<String, Object> res = new HashMap<>();
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("message",ex.getRootCause().getMessage());

        res.put("errors",errorMessage);
        res.put("success",false);
        return new ResponseEntity<>(res,HttpStatus.CONFLICT);
    }
}
