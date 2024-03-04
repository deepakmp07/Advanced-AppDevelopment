package com.example.backendv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendv2.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
}
