package com.example.backendv2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.backendv2.Entity.Payment;
import com.example.backendv2.Repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentrepo;
    
    public List<Payment> getAll(){
       return paymentrepo.findAll();
    }

    public Optional<Payment> getById(Long paymentId) {
        return paymentrepo.findById(paymentId);
}
}