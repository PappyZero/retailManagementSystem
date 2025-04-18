package com.example.helloWorldApplication.service;

import com.example.helloWorldApplication.model.Customer;
import com.example.helloWorldApplication.model.Payment;
import com.example.helloWorldApplication.repository.CustomerRepository;
import com.example.helloWorldApplication.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public List<Payment> findPaymentsByCustomer(Long customerId) {
        return paymentRepository.findByCustomer_Id(customerId);
    }

    public Payment createPaymentForCustomer(Long customerId, BigDecimal amount, String paymentMethod) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);

        if (customerOpt.isPresent()) {
            Payment payment = new Payment();
            payment.setCustomer(customerOpt.get());
            payment.setAmount(amount);
            payment.setPaymentMethod(paymentMethod);
            payment.setPaymentDate(LocalDateTime.now());

            return paymentRepository.save(payment);
        }

        return null; // In a real application, consider throwing an exception instead
    }

    public BigDecimal getTotalPaymentsForCustomer(Long customerId) {
        List<Payment> customerPayments = paymentRepository.findByCustomer_Id(customerId);
        return customerPayments.stream()
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}