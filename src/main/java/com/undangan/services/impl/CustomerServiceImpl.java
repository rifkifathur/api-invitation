package com.undangan.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.undangan.model.entities.Customer;
import com.undangan.repositories.CustomerRepository;
import com.undangan.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer){
        // customer.getId();
        
        return customerRepository.save(customer);
        // return customer;
    }

    @Override
    public void delete(Long id){
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id){
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer findByPath(String path){
        return customerRepository.findByPath(path);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    

}
