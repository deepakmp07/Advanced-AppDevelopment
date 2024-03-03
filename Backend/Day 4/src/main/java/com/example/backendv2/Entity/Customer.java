package com.example.backendv2.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    
    private String customerName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobileNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    // // @JoinColumn(foreignKey = )
    private List<Booking> booking;

    @OneToMany(mappedBy = "paymentId")
    List<Payment> payments;

    @OneToOne
    @JoinColumn(name = "customerRole")
    UserDetail user;

    @ManyToMany
    @JoinTable(name = "boat_owner", // Name of the intermediate table
            joinColumns = @JoinColumn(name = "boat_id"), // Foreign key column in the intermediate table for this entity
            inverseJoinColumns = @JoinColumn(name = "owner_id") // Foreign key column in the intermediate table for the
                                                                // other entity
    )
    List<Boat> boat;
}
