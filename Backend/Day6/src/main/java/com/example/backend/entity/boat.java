package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "boat")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boatId;
    private String boatName;
    private String ImageUrl;
    private String boatLocation;
    private String heading;
    private double rating;
    private String describe;
    private String boatCategory;
    @NonNull
    private boolean boatAvailable = true;
    private int price;
    private int capacity;

}
