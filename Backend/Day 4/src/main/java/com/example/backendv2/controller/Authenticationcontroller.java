package com.example.backendv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.backendv2.ProductService;
import com.example.backendv2.Entity.UserInfo;
import com.example.backendv2.Repository.UserInfoRepository;
import com.example.backendv2.dto.AuthRequest;
import com.example.backendv2.dto.Product;
import com.example.backendv2.service.JwtService;

@RequestMapping("/auth")
@Controller
public class Authenticationcontroller {

    @Autowired
    private AuthenticationManager authenticationManager; 
    
     @Autowired
    private ProductService service;

    @Autowired
    private JwtService jwtService;

    
     @Autowired
    private PasswordEncoder passwordEncoder;
     
    @Autowired
     private UserInfoRepository repository;

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }
}
