package com.example.backend.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.boat;
import com.example.backend.service.boatService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@Slf4j
@RequestMapping("/api/boat")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class boatController {
    
    @Autowired
    private boatService boatService;
    
    @GetMapping("/all")
    public List<boat> getAllBoats(){
        return boatService.getAllBoats();
    }

    @GetMapping("/{category}/all")
    public List<boat> getAllBoatsByCategory(@PathVariable String category){
        return boatService.getAllTopBoatsByCategory(category);
    }

    // @GetMapping("/all/{id}")
    // public String getMethodName(@PathVariable String email ,@RequestParam String param) {
    //     return boatService.getAllBoatsByEmail();
    // }
    

    @PostMapping("/add")
    public void addBoat(@RequestBody boat boat) {
        log.info(boat+"");
        boatService.addBoat(boat);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoat(@PathVariable("id") Long id){
        return boatService.deleteBoatById(id);
    }

}
