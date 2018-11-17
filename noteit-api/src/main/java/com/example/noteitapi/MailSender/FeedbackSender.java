package com.example.noteitapi.MailSender;

import org.springframework.stereotype.Component;

public interface FeedbackSender {
    public void sendFeedback(String name, String from, String feedback);
}
