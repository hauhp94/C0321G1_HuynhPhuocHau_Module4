package com.example.model.service.implement;

import com.example.model.entity.Customer;
import com.example.model.repository.CustomerRepository;
import com.example.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) throws SQLException {
        customerRepository.deleteById(id);
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> findByName(String name,Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(name,pageable);
    }

    @Override
    public List<Customer> findAllAndService() {
        return null;
    }
}
