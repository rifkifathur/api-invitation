package com.undangan.repositories;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.undangan.model.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    // public static final String FIND_MAN = "SELECT fullname_man, callname_man FROM customer";
    // @Query(value = FIND_MAN, nativeQuery = true)
    // public List<Object> findMan();
    @Query("SELECT c from Customer c WHERE c.path = :path")
    public Customer findByPath(@PathParam("path") String path);
}
