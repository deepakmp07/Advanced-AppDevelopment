package com.example.backendv2.Entity;

// import java.util.List;

// import org.hibernate.annotations.ManyToAny;

// import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name  = "passenger")
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;

    @ManyToOne    
    @JoinColumn(name = "booking_id")
    Booking book;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   Customer cust;
}
