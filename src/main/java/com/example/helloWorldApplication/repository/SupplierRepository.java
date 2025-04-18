package com.example.helloWorldApplication.repository;

import com.example.helloWorldApplication.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}