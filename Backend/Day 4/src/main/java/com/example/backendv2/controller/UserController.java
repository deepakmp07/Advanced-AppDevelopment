package com.example.backendv2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendv2.Entity.Boat;
import com.example.backendv2.Entity.Booking;
import com.example.backendv2.Entity.Customer;
import com.example.backendv2.Entity.Payment;
import com.example.backendv2.Entity.UserDetail;
import com.example.backendv2.Repository.BookingRepository;
import com.example.backendv2.service.BoatService;
import com.example.backendv2.service.BookingService;
import com.example.backendv2.service.CustomerService;
import com.example.backendv2.service.PaymentService;
import com.example.backendv2.service.UserService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Slf4j
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j
public class UserController {

    @Autowired
    private BoatService boatService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/registration/customer")
    public void AddUser(@RequestBody Customer cust) {
        log.info(cust+"");
        customerService.addCustomer(cust);
    }
    
    @GetMapping("customer/booking")
    public List<Booking> getAllBookings(){
      return bookingService.getAll();
    }
  
    @GetMapping("registration/customer")
    public List<Customer> getAllCustomer() {

        return customerService.getAll();
    }

    
    @PostMapping("/boat")
    public void addBoat(@RequestBody Boat boat) {
        log.info(boat+"");
        boatService.addBoat(boat);
    }

    @DeleteMapping("/boat/{boatId}")
    public ResponseEntity<?>  deleteBoat(@PathVariable Long boatId){
        return boatService.deleteBoatById(boatId);
    }
    @GetMapping("/payment")
    public List<Payment> getMethodName() {
        return paymentService.getAll();
    }

    @GetMapping("/payment/{userId}")
    public Optional<Payment> getMethodName(@PathVariable Long userId) {
        return paymentService.getById(userId);
    }
    
}
