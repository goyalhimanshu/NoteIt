package com.example.noteitapi.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component("FeedbackSender")
public class FeedbackMailSender implements FeedbackSender {

    private JavaMailSenderImpl mailSender;

    public FeedbackMailSender(Environment environment){
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("spring.mail.port")));
        mailSender.setUsername(environment.getProperty("spring.mail.username"));
        mailSender.setPassword(environment.getProperty("spring.mail.password"));
    }



    @Override
    public void sendFeedback(String name, String from, String feedback) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("goyal.himanshu@live.in");
        message.setSubject("New feedback from " + name);
        message.setText(feedback);
        message.setFrom(from);

        this.mailSender.send(message);

    }
}
