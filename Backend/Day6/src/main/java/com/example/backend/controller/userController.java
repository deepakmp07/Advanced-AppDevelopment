package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.AuthRequest;
import com.example.backend.entity.userRegister;
import com.example.backend.service.JwtService;
import com.example.backend.service.userService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/login")
@Slf4j
@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = "*")

public class userController {
    @Autowired
    private userService studentService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/all")
    public List<userRegister> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public userRegister getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @PutMapping("/up/{id}")
    public userRegister updateUser(@PathVariable("id") long id, @RequestBody userRegister user) {
        return studentService.updateUser(id, user);
    }

    @PostMapping("/addUser")
    public userRegister saveLogin(@RequestBody userRegister login) {
        return studentService.saveLogin(login);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        log.info(authRequest + "");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail()) + " "
                    + studentService.getRole(authRequest.getEmail())+" "+authRequest.getEmail();
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
        // return "hi";
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}