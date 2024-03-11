package com.example.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.entity.feedback;
import com.example.backend.service.feedbackService;
@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins ="http://localhost:5173/",allowedHeaders = "*")
public class feedbackController {
    @Autowired
    private feedbackService feedbackService;

    @GetMapping("/all")
    public List<feedback> getAllUsers() {
        return feedbackService.getAllUsers();
    }


    @PostMapping("/add")
    public feedback createfeedback(@RequestBody feedback feedback) {
        return feedbackService.createfeedback(feedback);
    }


    @PutMapping("/update")
    public feedback updatefeedback(@PathVariable Long id,@RequestBody feedback updatedfeedback) {
        return feedbackService.updatefeedback(id,updatedfeedback);
    }
    

    @DeleteMapping("/delete/{id}")
    public void deletefeedback(@PathVariable Long id) {
        feedbackService.deletefeedback(id);
    }
}