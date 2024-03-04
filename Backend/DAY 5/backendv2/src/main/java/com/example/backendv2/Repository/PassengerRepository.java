package com.example.backendv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendv2.Entity.Passengers;

public interface PassengerRepository extends JpaRepository<Passengers,Long> {
    
}
