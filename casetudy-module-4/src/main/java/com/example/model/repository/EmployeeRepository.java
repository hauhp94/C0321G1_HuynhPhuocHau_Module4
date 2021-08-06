package com.example.model.repository;

import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByEmployeeNameContaining(String keyWord,Pageable pageble);
    Page<Employee> findAllByIsDelete(int isDelete, Pageable pageable);
    List<Employee> findAllByIsDelete(int isDetele);

}
