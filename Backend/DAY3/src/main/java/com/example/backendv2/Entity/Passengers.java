package com.example.backendv2.Entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Passengers {
    private Long passengerId;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;

   @ManyToOne
   Booking book;
   
   @ManyToOne
   Customer cust;
}
