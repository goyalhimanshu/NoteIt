package com.example.noteitapi.controller;

import com.example.noteitapi.MailSender.FeedbackSender;
import com.example.noteitapi.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController {

    private FeedbackSender feedbackSender;

    public FeedbackController(FeedbackSender feedbackSender) {
        this.feedbackSender = feedbackSender;
    }

    @PostMapping
    public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) throws ValidationException{
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback has errors. Check Again");
        }
        this.feedbackSender.sendFeedback(
                feedback.getName(),
                feedback.getEmail(),
                feedback.getFeedback()
        );
    }


}
