package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;


import com.wishalpha.priyanshu.TaskManagementSystem.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String fromEmailId;

    @Override
    public void sendEmail(String emailTo, String name, int otp) throws MessagingException {
        Context context  = new Context();
        context.setVariable("subject","Forgot Password OTP");
        context.setVariable("name",name);
        context.setVariable("otp",otp);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String htmlContent = templateEngine.process("emails/forgot-password",context);
        helper.setFrom(fromEmailId);
        helper.setTo(emailTo);
        helper.setSubject("Forgot password otp");
        helper.setText(htmlContent,true);
        javaMailSender.send(mimeMessage);
    }
}
