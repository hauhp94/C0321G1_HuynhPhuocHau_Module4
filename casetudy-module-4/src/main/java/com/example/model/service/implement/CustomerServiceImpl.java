package com.example.model.service.implement;

import com.example.model.entity.Customer;
import com.example.model.repository.CustomerRepository;
import com.example.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAllByIsDelete(0,pageable);
    }

    @Override
    public Page<Customer> findAllCustomerUseService(Pageable pageable) {
        return customerRepository.findAllByIsDeleteAndServiceIdGreaterThan(0,0,pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllByIsDelete(0);
    }

    @Override
    public void save(Customer customer) throws Exception {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) throws SQLException {
        Customer customer=customerRepository.findById(id).get();
        customer.setIsDelete(1);
        customerRepository.save(customer);
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
        return customerRepository.searchByNameOrPhone(name,pageable);
    }

    @Override
    public List<Customer> findAllAndService() {
        return null;
    }

    @Override
    public boolean isExistCustomerCode(String code) {
        return customerRepository.existsByCustomerCode(code);
    }
}
