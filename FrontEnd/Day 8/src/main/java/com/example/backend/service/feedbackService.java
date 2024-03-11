package com.example.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.feedback;
import com.example.backend.repository.feedbackRepo;

import java.util.List;
import java.util.Optional;

@Service
public class  feedbackService {
    @Autowired
    private  feedbackRepo userRepo;

    public List<feedback> getAllUsers() {
        return userRepo.findAll();
    }

    @SuppressWarnings("null")
    public Optional<feedback> getfeedbackById(Long id) {
        return userRepo.findById(id);
    }

    @SuppressWarnings("null")
    public feedback createfeedback(feedback feedback) {
        return userRepo.save(feedback);
    }

    public feedback updatefeedback(Long id, feedback updatedfeedback) {
        @SuppressWarnings("null")
        Optional<feedback> feedback = userRepo.findById(id);
        if (feedback.isPresent()) {
            updatedfeedback.setId(id);
            return userRepo.save(updatedfeedback);
        } else {
            throw new RuntimeException("Booking not found");
        }
    }

    @SuppressWarnings("null")
    public void deletefeedback(Long id) {
        userRepo.deleteById(id);
    }
}
