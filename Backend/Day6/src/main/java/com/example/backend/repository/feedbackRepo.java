package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.feedback;

public interface feedbackRepo extends JpaRepository<feedback,Long>{
    
}
