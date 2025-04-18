package com.example.helloWorldApplication.repository;

import com.example.helloWorldApplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}