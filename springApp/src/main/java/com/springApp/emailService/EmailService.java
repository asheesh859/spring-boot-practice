package com.springApp.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void emailSender(String to ,String subject , String body){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(to);
        sm.setSubject(subject);
        sm.setText(body);
        javaMailSender.send(sm);
    }
}
