package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;


import com.wishalpha.priyanshu.TaskManagementSystem.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String fromEmailId;

    @Override
    public void sendEmail(String emailTo, String subject, Context context, String templatePath){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            String htmlContent = templateEngine.process(templatePath,context);
            helper.setFrom(fromEmailId);
            helper.setTo(emailTo);
            helper.setSubject(subject);
            helper.setText(htmlContent,true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.info("Email Messaging Exception",e.getMessage());
        }

    }
}
