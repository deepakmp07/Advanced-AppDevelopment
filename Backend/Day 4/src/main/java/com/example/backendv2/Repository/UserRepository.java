package com.example.backendv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendv2.Entity.UserDetail;

public interface UserRepository extends JpaRepository<UserDetail, Long>{
    
}
