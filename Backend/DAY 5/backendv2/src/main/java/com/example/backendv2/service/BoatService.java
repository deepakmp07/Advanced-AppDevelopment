package com.example.backendv2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backendv2.Entity.Boat;
import com.example.backendv2.Repository.BoatRepository;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepo;
    
    public List<Boat> getAllBoats(){
        return boatRepo.findAll();
    }

    public  ResponseEntity<?>  deleteBoatById(Long id){
       if(boatRepo.existsById(id)){
        boatRepo.deleteById(id);
        return ResponseEntity.ok().build();
       }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boat with ID: " + id + " not found");
       }
    }
    public void addBoat(Boat boat){
        boatRepo.save(boat);
    }
}
