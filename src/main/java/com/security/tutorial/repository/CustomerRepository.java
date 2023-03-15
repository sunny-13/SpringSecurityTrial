package com.security.tutorial.repository;

import com.security.tutorial.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    Optional<Customer> findById(String customerId);
    Optional<Customer> findByCustomerName(String customerName);
}
