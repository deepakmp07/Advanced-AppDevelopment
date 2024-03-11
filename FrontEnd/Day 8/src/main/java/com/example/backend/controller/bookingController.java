package com.example.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.entity.userBooking;

import com.example.backend.service.bookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/booking")
@Slf4j
@CrossOrigin(origins ="http://localhost:5173/",allowedHeaders = "*")
public class bookingController {
    @Autowired
    private bookingService bookingService;

    @GetMapping("/all")
    public List<userBooking> getAllUsers() {
        return bookingService.getAllUsers();
    }


    @PostMapping("/add")
    public userBooking createuserBooking(@RequestBody userBooking userBooking) {
        return bookingService.createuserBooking(userBooking);
    }


    @PutMapping("/update/{id}")
    public userBooking updateuserBooking(@PathVariable Long id,@RequestBody userBooking updateduserBooking) {
        log.info(updateduserBooking+"");
        return bookingService.updateuserBooking(id,updateduserBooking);
    }
    

    @DeleteMapping("/delete/{id}")
    public void deleteuserBooking(@PathVariable Long id) {
        bookingService.deleteuserBooking(id);
    }
}