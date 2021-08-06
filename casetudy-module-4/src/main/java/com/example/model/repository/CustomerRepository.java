package com.example.model.repository;

import com.example.model.entity.Contract;
import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByCustomerNameContaining(String name,Pageable pageable);
//    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByIsDelete(int isDelete,Pageable pageable);
    List<Customer> findAllByIsDelete(int isDetele);


}
