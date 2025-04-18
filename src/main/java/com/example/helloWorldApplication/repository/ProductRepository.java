package com.example.helloWorldApplication.repository;

import com.example.helloWorldApplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBySupplier_Id(Long supplierId);
}