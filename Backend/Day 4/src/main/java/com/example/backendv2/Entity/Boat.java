package com.example.backendv2.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;

// import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name = "boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boatId;
    private String boatName;
    private String ImageUrl;
    private String boatLocation;
    private String boatCategory;
    private boolean boatAvailable;
    private int price;
    private int capacity;

    // @OneToMany
    // @JoinColumn(name = "bookings", referencedColumnName = "boatId")
    // private List<Booking> bookings;

    // @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    // @JoinTable(name = "boat_customer", joinColumns = @JoinColumn(name =
    // "boat_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    // private List<Customer> customers = new ArrayList<>();
}
