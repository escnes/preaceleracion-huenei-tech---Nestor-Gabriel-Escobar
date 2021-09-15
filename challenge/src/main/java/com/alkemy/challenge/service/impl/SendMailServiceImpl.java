package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.model.Usuario;
import com.alkemy.challenge.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class SendMailServiceImpl implements SendMailService{

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(Usuario usuario) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("<"+usuario.getMail()+">");
        mailMessage.setFrom("<alkemychallengenesesc@gmail.com>");
        mailMessage.setSubject("Bienvenido");
        mailMessage.setText("Su cuenta ha sido creada con exito");
        mailSender.send(mailMessage);
    }
    
    
}
