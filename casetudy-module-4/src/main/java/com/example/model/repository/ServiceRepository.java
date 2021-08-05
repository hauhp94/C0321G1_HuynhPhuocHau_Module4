package com.example.model.repository;

import com.example.model.entity.Customer;
import com.example.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Page<Service> findAll(Pageable pageable);

}
