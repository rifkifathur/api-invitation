package com.undangan.services;

import java.util.List;

import com.undangan.model.entities.Customer;

public interface CustomerService {
    
    Customer create(Customer customer);

    Customer update(Long id, Customer customer);

    void delete(Long id);

    Customer findById(Long id);

    Customer findByPath(String path);
    
    List<Customer> findAll();
}