package com.example.backendv2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ErrorHandling.EmailAlreadyExistsException;
import com.example.backendv2.Entity.Customer;
import com.example.backendv2.Repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository custrepo;
@PersistenceContext
    private EntityManager entityManager;

    public void saveCustomer(Customer customer) throws EmailAlreadyExistsException {
        // Check if the email already exists
        if (isEmailExists(customer.getEmail())) {
            throw new EmailAlreadyExistsException("Email address already exists");
        }
        entityManager.persist(customer);
    }

    private boolean isEmailExists(String email) {
        // Query to check if any other customer already has the same email address
        return entityManager.createQuery("SELECT COUNT(c) FROM Customer c WHERE c.email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult() > 0;
    }
    public void addCustomer(Customer cust) {
        custrepo.save(cust);
    }

    public List<Customer> getAll() {
        return custrepo.findAll();
    }

    // public void addUser(Customer cust){
    // custrepo.save(cust);
    // }
    public List<Customer> getAllCust() {
        return custrepo.findAll();
    }
}
