package com.example.backend.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.entity.userRegister;
import com.example.backend.repository.userRepo;


@Service
public class userService {
    @Autowired
    private userRepo studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<userRegister> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<userRegister> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public userRegister saveLogin(userRegister login) {
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        return studentRepository.save(login);
    }
   
    public userRegister updateUser(long id, userRegister newUser) {
        userRegister existingUser = studentRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));

        existingUser.setName(newUser.getName());
        existingUser.setEmail(newUser.getEmail());
        existingUser.setRole(newUser.getRole());
        existingUser.setPassword(passwordEncoder.encode(existingUser.getPassword()));

        return studentRepository.save(existingUser);
    }
    public String getRole(String email) {
        return studentRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Invalid Email!"))
        .getRole();
    }
    
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}