package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.entity.boat;

public interface boatRepository extends JpaRepository<boat,Long>{

    List<boat> findByBoatCategory(String boatCategory); // Method name follows the Spring Data JPA naming convention

}
