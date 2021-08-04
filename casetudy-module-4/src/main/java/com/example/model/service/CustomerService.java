package com.example.model.service;

import com.example.model.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService  {
    List<Customer> findAll();

    void save(Customer customer);

    void remove(int id) throws SQLException;

    void update(int id, Customer customer);

    Customer findById(int id);

    List<Customer> findByName(String name);

    List<Customer> findAllAndService();
}
