package com.example.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.userBooking;
import com.example.backend.repository.bookingRepo;

import java.util.List;
import java.util.Optional;

@Service
public class  bookingService {
    @Autowired
    private  bookingRepo userRepo;

    public List<userBooking> getAllUsers() {
        return userRepo.findAll();
    }

    @SuppressWarnings("null")
    public Optional<userBooking> getuserBookingById(Long id) {
        return userRepo.findById(id);
    }

    @SuppressWarnings("null")
    public userBooking createuserBooking(userBooking userBooking) {
        return userRepo.save(userBooking);
    }

    public userBooking updateuserBooking(Long id, userBooking updateduserBooking) {
        @SuppressWarnings("null")
        Optional<userBooking> userBooking = userRepo.findById(id);
        if (userBooking.isPresent()) {
            updateduserBooking.setId(id);
            return userRepo.save(updateduserBooking);
        } else {
            throw new RuntimeException("Booking not found");
        }
    }

    @SuppressWarnings("null")
    public void deleteuserBooking(Long id) {
        userRepo.deleteById(id);
    }
}
