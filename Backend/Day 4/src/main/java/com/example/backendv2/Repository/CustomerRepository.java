package com.example.backendv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendv2.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
}
