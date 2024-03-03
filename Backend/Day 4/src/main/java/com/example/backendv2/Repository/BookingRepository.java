package com.example.backendv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendv2.Entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    
}
