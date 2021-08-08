package com.example.model.service;

import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService  {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllCustomerUseService(Pageable pageable);

    List<Customer> findAll();
    void save(Customer customer);
    void update(int id, Customer customer);

    void remove(int id) throws SQLException;


    Customer findById(int id);

    Page<Customer> findByName(String name,Pageable pageable);

    List<Customer> findAllAndService();
}
