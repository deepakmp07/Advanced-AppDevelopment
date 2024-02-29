package com.example.backendv2.controller;

import com.example.backendv2.Entity.Register;
import com.example.backendv2.Entity.User;
import com.example.backendv2.Repository.RegisterRepository;
import com.example.backendv2.Repository.UserRepository;
// import com.example.backendv2.service.UserRegister;
import com.example.backendv2.service.UserRegisterService;
import com.example.backendv2.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
// @RequestMapping("/api/user")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userrepo;
    @Autowired
    private UserRegisterService uRegisterService;
    @Autowired
    private RegisterRepository rRepo;
    @Autowired
    private UserRegisterService uregser;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void UserLogins(@RequestBody User user) {
        userrepo.save(user);
    }

    @GetMapping("/register/all")
    public List<Register> getAllUser() {
        return  rRepo.findAll();
    }
    
    @PostMapping("/add")
    public Register postNewUser(@RequestBody Register register ) {
        System.out.print(register);
        return uregser.adddetails(register);
    }
    

    @GetMapping("/getAll")
    public List<User> getMethodName() {
        return userrepo.findAll();
    }
    
    @GetMapping("/{id}")
public ResponseEntity<?> getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    if (user != null) {
        return ResponseEntity.ok(user); // Return the user if found
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with id: " + id);
    }
}

    
    
}
