package com.example.backendv2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// import com.example.backendv2.Entity.Customer;
import com.example.backendv2.Entity.UserInfo;
// import com.example.backendv2.Repository.CustomerRepository;
import com.example.backendv2.Repository.UserInfoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserInfoService {

    @Autowired
   private UserInfoRepository userRepo;

    // @Autowired
    // private CustomerRepository custrepo;

    @Autowired
private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    public String addUser(UserInfo user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "user added to system ";
   }

    // public void addUsers(Customer cust) {
    //     custrepo.save(cust);
    // }

    public List<UserInfo> getAllUsers() {
        return userRepo.findAll();
    }

    // public List<Customer> getAllCust() {
    //     return custrepo.findAll();
    // }
}
