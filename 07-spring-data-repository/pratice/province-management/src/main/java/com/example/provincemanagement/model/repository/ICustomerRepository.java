package com.example.provincemanagement.model.repository;

import com.example.provincemanagement.model.bean.Customer;
import com.example.provincemanagement.model.bean.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {

    Page<Customer> findAll(Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
