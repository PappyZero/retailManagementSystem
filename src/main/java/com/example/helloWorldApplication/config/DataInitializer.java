package com.example.helloWorldApplication.config;

import com.example.helloWorldApplication.model.Customer;
import com.example.helloWorldApplication.model.Payment;
import com.example.helloWorldApplication.model.Product;
import com.example.helloWorldApplication.model.Supplier;
import com.example.helloWorldApplication.repository.CustomerRepository;
import com.example.helloWorldApplication.repository.PaymentRepository;
import com.example.helloWorldApplication.repository.ProductRepository;
import com.example.helloWorldApplication.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) {
        // Create suppliers
        Supplier supplier1 = new Supplier();
        supplier1.setName("Lagos Electronics");
        supplier1.setContactName("Adebayo Ogunlesi");
        supplier1.setEmail("adebayo@lagoselectronics.com");
        supplier1.setPhone("+234 801 234 5678");
        supplier1.setAddress("17 Marina Street, Lagos");
        supplierRepository.save(supplier1);

        Supplier supplier2 = new Supplier();
        supplier2.setName("Abuja Home Goods");
        supplier2.setContactName("Ngozi Okafor");
        supplier2.setEmail("ngozi@abujahomegoods.com");
        supplier2.setPhone("+234 802 345 6789");
        supplier2.setAddress("42 Aso Rock Avenue, Abuja");
        supplierRepository.save(supplier2);

        // Create products
        Product product1 = new Product();
        product1.setName("Nigerian Handmade Pottery");
        product1.setDescription("Traditional pottery made by Nigerian artisans");
        product1.setPrice(new BigDecimal("15.99"));
        product1.setStockQuantity(50);
        product1.setSupplier(supplier2);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Solar Power Bank");
        product2.setDescription("10000mAh solar power bank");
        product2.setPrice(new BigDecimal("29.99"));
        product2.setStockQuantity(100);
        product2.setSupplier(supplier1);
        productRepository.save(product2);

        // Create customers
        Customer customer1 = new Customer();
        customer1.setName("Chinua Achebe");
        customer1.setEmail("chinua@example.com");
        customer1.setPhone("+234 803 456 7890");
        customer1.setAddress("15 Literature Avenue, Enugu");
        customer1.getPurchasedProducts().add(product1);
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Wole Soyinka");
        customer2.setEmail("wole@example.com");
        customer2.setPhone("+234 804 567 8901");
        customer2.setAddress("7 Nobel Prize Street, Abeokuta");
        customer2.getPurchasedProducts().add(product1);
        customer2.getPurchasedProducts().add(product2);
        customerRepository.save(customer2);

        // Create payments
        Payment payment1 = new Payment();
        payment1.setAmount(new BigDecimal("15.99"));
        payment1.setPaymentDate(LocalDateTime.now().minusDays(5));
        payment1.setPaymentMethod("Credit Card");
        payment1.setCustomer(customer1);
        paymentRepository.save(payment1);

        Payment payment2 = new Payment();
        payment2.setAmount(new BigDecimal("45.98"));
        payment2.setPaymentDate(LocalDateTime.now().minusDays(2));
        payment2.setPaymentMethod("PayPal");
        payment2.setCustomer(customer2);
        paymentRepository.save(payment2);
    }
}