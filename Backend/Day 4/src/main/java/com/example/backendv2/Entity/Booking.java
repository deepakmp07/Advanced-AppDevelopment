package com.example.backendv2.Entity;

import java.util.List;

import org.springframework.beans.factory.config.CustomEditorConfigurer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;

import jakarta.persistence.CascadeType;
// import org.hibernate.annotations.ManyToAny;
// import org.hibernate.mapping.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
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
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String firstname;
    private String lastname;
    private int noOfPersons;
    private Date fromDate;
    private String email;
    private Long phoneNumber;
    private Date toDate;
    private Double totalPrice;

    @ManyToOne
@JoinColumn(name = "customerId", referencedColumnName =  "customerId")
@JsonIgnore
private Customer customer;

    @ManyToOne
    @JoinColumn(name = "boatId",referencedColumnName = "boatId")
    private Boat boat;

    @OneToMany(mappedBy = "passengerId")
    List<Passengers> passenger;

    @OneToOne
    @JoinColumn(name = "paymentId" , referencedColumnName = "paymentId")
    Payment payment;
}
