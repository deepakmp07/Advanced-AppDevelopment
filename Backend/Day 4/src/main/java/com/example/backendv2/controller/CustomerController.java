package com.example.backendv2.controller;

import com.example.backendv2.Entity.Boat;
import com.example.backendv2.Entity.Booking;
import com.example.backendv2.Entity.Customer;
import com.example.backendv2.service.BoatService;
import com.example.backendv2.service.BookingService;
import com.example.backendv2.service.CustomerService;


import java.util.List;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


// @AllArgsConstructor
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    private CustomerService custservice;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BoatService boatService;

    @GetMapping("/registration/customer")
    public List<Customer> getAllCustomer() {
        return custservice.getAllCust();
    }

    @PostMapping("/booking")
    public void addBooking(@RequestBody Booking booking) {
        System.out.print(booking);
         bookingService.addBooking(booking);
    }
    
    @GetMapping("/boat")
    public List<Boat> AllBoat() {
        return boatService.getAllBoats();
    }
    
    @GetMapping("/booking/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Long id) {
        return bookingService.deleteBookingById(id);
    }

    @PutMapping("booking/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable Long id, @RequestBody Booking entity) {        
        return bookingService.updateBookingById(id,entity);
    }

}
