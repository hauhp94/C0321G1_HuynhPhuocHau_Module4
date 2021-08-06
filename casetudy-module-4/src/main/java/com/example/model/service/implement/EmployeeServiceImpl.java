package com.example.model.service.implement;

import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import com.example.model.repository.EmployeeRepository;
import com.example.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAllByIsDelete(0,pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByIsDelete(0);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void remove(int id) throws SQLException {
        Employee employee = employeeRepository.findById(id).get();
        employee.setIsDelete(1);
        employeeRepository.save(employee);
    }

    @Override
    public void update(int id, Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(name,pageable);
    }

    @Override
    public List<Employee> findAllAndService() {
        return null;
    }
}
