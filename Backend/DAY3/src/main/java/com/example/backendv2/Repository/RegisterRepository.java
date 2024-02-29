package com.example.backendv2.Repository;

import com.example.backendv2.Entity.Register;
import com.example.backendv2.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    // public Optional<Register> findById(Long id);
    // You can add custom query methods here if needed
}
