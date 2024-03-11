package com.example.backend.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.entity.boat;
import com.example.backend.repository.boatRepository;

@Service
public class boatService {

    @Autowired
    private boatRepository boatrepo;
    
    public List<boat> getAllBoats(){
       return boatrepo.findAll();
    }
     
    public List<boat> getAllTopBoatsByCategory(String cat){
        return boatrepo.findByBoatCategory(cat);
     }

    // public List<boat> getAllBoatsByEmail(String email){
    //     return boatrepo.findAllByEmail(email);
    //  }


    public void addBoat(boat boat){
        boatrepo.save(boat);
    }

    public ResponseEntity<?> deleteBoatById(Long id){
        if(boatrepo.existsById(id)){
            boatrepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boat not found");
        }
    }
}
