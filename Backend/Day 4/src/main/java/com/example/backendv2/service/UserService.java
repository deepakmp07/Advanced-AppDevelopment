package com.example.backendv2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendv2.Entity.Boat;
import com.example.backendv2.Entity.UserDetail;
import com.example.backendv2.Repository.BoatRepository;
import com.example.backendv2.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    
    public void adduser(UserDetail user){
         userRepo.save(user);
    }
}
