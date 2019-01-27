package com.spring.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {
    
    @Autowired
    MailSender mailSender;

    @PostMapping("/sendEmail")
    public String triggerEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("zahid.indher@gmail.com");
        message.setCc("zindher@yahoo.com","zahid.indher@appl.com");
        message.setBcc("zahid.indher@live.com","zahidhussain@royalcyber.com");
        message.setSubject("Spring Boot Test Email.");
        message.setFrom("zindher@gmail.com");
        message.setText("Congrats! This is Test email from Spring Boot Project");
        try {
            mailSender.send(message);
            return "{\"Email send successfully.\": \"OK\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"Unable to send Email.\": \"Error\"}";
        }
    }

}