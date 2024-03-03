package com.example.backendv2.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.backendv2.Entity.Booking;
import com.example.backendv2.Repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookrepo;

    public void addBooking(Booking booking) {
         bookrepo.save(booking);
    }

    public List<Booking> getAll(){
        return  bookrepo.findAll();
    }
    public ResponseEntity<?> deleteBookingById(Long id) {
        if (bookrepo.existsById(id)) {
            bookrepo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        }
    }

    public List<Booking> getAllBookings() {
        return bookrepo.findAll();
    }

    public void saveBooking(Booking booking) {
        bookrepo.save(booking);
    }

    public ResponseEntity<?> updateBookingById(Long id, Booking book) {
        return bookrepo.findById(id).map(booking -> {
            booking.setFirstname(book.getFirstname());
            return bookrepo.save(booking);
        }).map(updatedBooking -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }
}
