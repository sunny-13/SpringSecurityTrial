package com.security.tutorial.service;

import com.security.tutorial.entity.Customer;
import com.security.tutorial.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    public void createCustomer(Customer customer){
        customer.setCustomerId(UUID.randomUUID().toString());
        customer.setCustomerPassword(new BCryptPasswordEncoder().encode(customer.getCustomerPassword()));
        customerRepository.save(customer);
    }

}
