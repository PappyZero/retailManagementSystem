package com.example.helloWorldApplication.service;

import com.example.helloWorldApplication.model.Product;
import com.example.helloWorldApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findProductsBySupplier(Long supplierId) {
        return productRepository.findBySupplier_Id(supplierId);
    }

    public void updateProductStock(Long productId, Integer quantity) {
        productRepository.findById(productId).ifPresent(product -> {
            product.setStockQuantity(product.getStockQuantity() + quantity);
            productRepository.save(product);
        });
    }
}