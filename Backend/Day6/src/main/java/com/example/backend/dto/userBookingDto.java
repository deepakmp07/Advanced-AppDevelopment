package com.example.backend.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class userBookingDto {
    private Long id;
    private String fullName;
    private String email;
    private Long phone;
    private Date startDate;
    private Date endDate;
    private int numGuests;
    private String address;
    private String state;
    private String country;
}
