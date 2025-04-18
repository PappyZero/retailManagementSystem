package com.example.helloWorldApplication.service;

import com.example.helloWorldApplication.model.Customer;
import com.example.helloWorldApplication.model.Product;
import com.example.helloWorldApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public void addProductToCustomer(Customer customer, Product product) {
        customer.getPurchasedProducts().add(product);
        customerRepository.save(customer);
    }
}