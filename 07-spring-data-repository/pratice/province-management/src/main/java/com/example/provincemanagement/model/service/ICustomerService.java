package com.example.provincemanagement.model.service;


import com.example.provincemanagement.model.bean.Customer;
import com.example.provincemanagement.model.bean.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
    public Iterable<Customer> findAllByProvince(Province province);

    public Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
