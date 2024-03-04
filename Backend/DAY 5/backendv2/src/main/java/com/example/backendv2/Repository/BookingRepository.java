package com.example.backendv2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backendv2.Entity.Booking;


@Repository
// @Slf4j
public interface BookingRepository extends JpaRepository<Booking,Long> {
    
    // @Query("SELECT b FROM Booking b WHERE b.customer.email = :email")
    // List<Booking> geBookingsById(@Param("email") String email);
    
    
}
