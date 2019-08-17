package com.xiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MailConfig {

    @Bean
    public JavaMailSenderImpl mailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("mail.mycompany.com");
        return javaMailSender;
    }

    @Bean
    public SimpleMailMessage templateMessage(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("customerservice@mycompany.com");
        simpleMailMessage.setSubject("Your order");
        return simpleMailMessage;
    }
}
