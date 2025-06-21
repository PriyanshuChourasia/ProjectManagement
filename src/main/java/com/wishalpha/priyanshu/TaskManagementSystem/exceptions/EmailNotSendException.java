package com.wishalpha.priyanshu.TaskManagementSystem.exceptions;


public class EmailNotSendException extends RuntimeException {
    public EmailNotSendException(String message){
        super(message);
    }
}
