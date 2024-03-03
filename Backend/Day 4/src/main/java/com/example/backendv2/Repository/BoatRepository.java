package com.example.backendv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendv2.Entity.Boat;

public interface BoatRepository extends JpaRepository<Boat,Long>{
    
}
