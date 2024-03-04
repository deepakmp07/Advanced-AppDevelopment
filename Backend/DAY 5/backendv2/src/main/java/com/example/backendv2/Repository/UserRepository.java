package com.example.backendv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.backendv2.Entity.UserDetail;
import com.example.backendv2.Entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo,Integer>{
    
}
