package com.example.model.repository;

import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import com.example.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Page<Service> findAll(Pageable pageable);
    Page<Service> findAllByIsDelete(int isDelete, Pageable pageable);
    List<Service> findAllByIsDelete(int isDetele);

}
