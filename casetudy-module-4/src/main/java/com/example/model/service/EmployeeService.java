package com.example.model.service;

import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll();
    void save(Employee employee);

    void remove(int id) throws SQLException;

    void update(int id, Employee employee);

    Employee findById(int id);

    Page<Employee> findByName(String name,Pageable pageable);

    List<Employee> findAllAndService();
}
