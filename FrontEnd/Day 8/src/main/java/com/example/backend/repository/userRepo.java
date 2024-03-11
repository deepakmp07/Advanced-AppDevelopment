package com.example.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.userRegister;

@Repository
public interface userRepo extends JpaRepository<userRegister,Long>{
    Optional<userRegister> findByEmail(String email);
}
