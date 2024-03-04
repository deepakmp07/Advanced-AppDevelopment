package com.example.backendv2.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.backendv2.Entity.Boat;
import com.example.backendv2.Entity.Booking;
// import com.example.backendv2.Entity.Customer;
import com.example.backendv2.Entity.Passengers;
import com.example.backendv2.Repository.BoatRepository;
import com.example.backendv2.Repository.BookingRepository;
// import com.example.backendv2.Repository.CustomerRepository;
import com.example.backendv2.Repository.PassengerRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingService {
    @Autowired
    private BookingRepository bookrepo;

    @Autowired
    private BoatRepository boatrepo;

    // @Autowired
    // private CustomerRepository custrepo;

    // @Autowired
    // private PassengerRepository passrepo;
    // public void addBooking(Booking booking) {
    //     Boat boat = boatrepo.findById(booking.getBoat().getBoatId())
    //     .orElseThrow(() -> new EntityNotFoundException("Boat not found with id: "));
    //     booking.setBoat(boat);
    //     Customer cust = custrepo.findById(booking.getCustomer().getCustomerId())
    //     .orElseThrow(() -> new EntityNotFoundException("Boat not found with id: "));
    //     booking.setCustomer(cust);
    //     bookrepo.save(booking);
    // }


    public List<Booking> getAll() {
        return bookrepo.findAll();
    }

    public ResponseEntity<?> deleteBookingById(Long id) {
        if (bookrepo.existsById(id)) {
            bookrepo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        }
    }

    // public List<Booking> getBookingsByCustomerEmail(String email) {
    //     log.info(email+"....././......///////.......//");
    //     return bookrepo.geBookingsById(email);
    //     // return bookrepo.findAll();
    // }


    public List<Booking> getAllBookings() {
        log.info("hi");
        List<Booking> book = bookrepo.findAll();
        log.info("everyone");
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
