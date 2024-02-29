package com.example.backendv2.Entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name  = "BoatDetails")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long boatId;
     private String ImageUrl;
     private int boatLocation;
     private String boatCategory;
     private int BoatAvailable;
     private int price;
     private int capacity;

     @OneToMany
     List<Booking> bookings;
     @ManyToMany
     List<Customer> customer;
}
