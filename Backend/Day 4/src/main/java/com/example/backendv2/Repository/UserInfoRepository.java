package com.example.backendv2.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendv2.Entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);

}
 