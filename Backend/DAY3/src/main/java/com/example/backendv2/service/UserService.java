package com.example.backendv2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendv2.Entity.User;
import com.example.backendv2.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        // Call the UserRepository to retrieve the user by ID
        return userRepository.findById(id).orElse(null);
    }

    // Add more service methods as needed

}
