package com.example.model.service;

import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService  {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void remove(int id) throws SQLException;

    void update(int id, Customer customer);

    Customer findById(int id);

    Page<Customer> findByName(String name,Pageable pageable);

    List<Customer> findAllAndService();
}
