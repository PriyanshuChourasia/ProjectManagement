package com.wishalpha.priyanshu.TaskManagementSystem.services;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(String emailTo,String name, int otp) throws MessagingException;
}
