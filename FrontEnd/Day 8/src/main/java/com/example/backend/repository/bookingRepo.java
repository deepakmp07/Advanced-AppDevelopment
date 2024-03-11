package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.userBooking;

@Repository
public interface bookingRepo extends JpaRepository<userBooking,Long> {
    
}
