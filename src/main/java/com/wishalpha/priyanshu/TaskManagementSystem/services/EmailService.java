package com.wishalpha.priyanshu.TaskManagementSystem.services;

import jakarta.mail.MessagingException;
import org.thymeleaf.context.Context;

public interface EmailService {
    void sendEmail(String emailTo, String subject, Context context, String templatePath) throws MessagingException;
}
