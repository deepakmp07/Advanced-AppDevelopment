package com.example.backendv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.example.backendv2.Entity.Register;
import com.example.backendv2.Repository.RegisterRepository;
import com.example.backendv2.Repository.UserRepository;

@Service
public class UserRegisterService {

    private RegisterRepository regrepo;

    @Autowired
     public UserRegisterService(RegisterRepository reg) {
        this.regrepo = reg;
    }
    
    public Register adddetails(Register register){
         return regrepo.save(register);
    }

}
