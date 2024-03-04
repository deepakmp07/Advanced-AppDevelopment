package com.example.backendv2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendv2.Entity.Boat;
import com.example.backendv2.Entity.Booking;
import com.example.backendv2.Entity.Payment;
import com.example.backendv2.Entity.UserInfo;
import com.example.backendv2.service.BoatService;
import com.example.backendv2.service.BookingService;
// import com.example.backendv2.service.CustomerService;
import com.example.backendv2.service.PaymentService;
import com.example.backendv2.service.UserInfoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j
@Tag(name = "Crypto Information", description = "Endpoints related to crypto information")
public class UserController {

    @Autowired
    private BoatService boatService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BookingService bookingService;

    // @Autowired
    // private CustomerService customerService;

    @Autowired
    private UserInfoService userService;

    // @Autowired
    // private CustomerService custservice;

    // @Autowired
    // private BookingService bookingService;

    // @Autowired
    // private BoatService boatService;
   
    @GetMapping("admin/allUsers")
    public List<UserInfo> getAllUsers() {
        return userService.getAllUsers();
    }

    // @PostMapping("/addBooking")
    // public void addBooking(@RequestBody Booking booking) {
    //     // log.info(booking.getBoat() + "ddieidiedhiehiihihieidieihdheiieiehied..../................");
    //     bookingService.addBooking(booking);
    // }

    @GetMapping("/getAllBoats")
    public List<Boat> AllBoat() {
        return boatService.getAllBoats();
    }

    @GetMapping("admin/getAllBooking")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

    // @GetMapping("getBooking/{email}")
    // public ResponseEntity<List<Booking>> getBookingsByEmail(@PathVariable String email) {
    //     // log.info(email+"######");
    //     List<Booking> bookings = bookingService.getBookingsByCustomerEmail(email);
    //     return ResponseEntity.status(HttpStatus.OK).body(bookings);
    // }


    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Long id) {
        return bookingService.deleteBookingById(id);
    }

    @PutMapping("booking/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable Long id, @RequestBody Booking entity) {
        return bookingService.updateBookingById(id, entity);
    }

    @PostMapping("/newUser")
    public void AddUser(@RequestBody UserInfo user) {
        log.info(user + "");
        userService.addUser(user);
    }

    // @GetMapping("/customerBooking")
    // public List<Booking> getAllBookings() {
    //     log.info("#########");
    //     return bookingService.getAll();
    // }

    // @io.swagger.v3.oas.annotations.Operation(summary = "Get aggregated stats for a crypto", description = "Returns the aggregated statistics for a specific crypto symbol.")
    // @GetMapping("/registration/customer")
    // public List<Customer> getAllCustomer() {

    //     return customerService.getAll();
    // }

    @PostMapping("admin/addBoat")
    public void addBoat(@RequestBody Boat boat) {
        // log.info(boat + "");
        boatService.addBoat(boat);
    }

    @DeleteMapping("admin/deleteBoat/{boatId}")
    public ResponseEntity<?> deleteBoat(@PathVariable Long boatId) {
        return boatService.deleteBoatById(boatId);
    }

    @GetMapping("admi/payment")
    public List<Payment> getMethodName() {
        return paymentService.getAll();
    }

    @GetMapping("/payment/{userId}")
    public Optional<Payment> getMethodName(@PathVariable Long userId) {
        return paymentService.getById(userId);
    }

}
