package com.example.backend.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.backend.entity.userRegister;
import com.example.backend.repository.userRepo;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private userRepo repository;

    @Override
    public UserDetails loadUserByUsername(String usermail) throws UsernameNotFoundException {
        Optional<userRegister> loginInfo = repository.findByEmail(usermail);
        return loginInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + usermail));

    }
}