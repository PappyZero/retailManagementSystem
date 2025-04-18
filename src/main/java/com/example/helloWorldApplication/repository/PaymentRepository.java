package com.example.helloWorldApplication.repository;

import com.example.helloWorldApplication.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByCustomer_Id(Long customerId);
}