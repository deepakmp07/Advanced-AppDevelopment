package com.example.backendv2.Entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

public class Customer {
    private Long customerId;
    private String customerName;
    private String email;
    private String mobileNumber;

    @OneToMany
    List<Booking> book;

    @OneToMany
    List<Payment> payments;

    @OneToMany
    User user;

    @ManyToMany
    List<Boat> boat;
}
