package com.example.helloWorldApplication.service;

import com.example.helloWorldApplication.model.Product;
import com.example.helloWorldApplication.model.Supplier;
import com.example.helloWorldApplication.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductService productService;

    public List<Supplier> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> findSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public void addProductToSupplier(Long supplierId, Product product) {
        supplierRepository.findById(supplierId).ifPresent(supplier -> {
            product.setSupplier(supplier);
            productService.saveProduct(product);
        });
    }
}