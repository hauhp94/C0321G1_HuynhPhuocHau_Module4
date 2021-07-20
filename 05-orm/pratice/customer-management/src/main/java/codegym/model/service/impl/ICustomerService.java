package codegym.model.service.impl;

import codegym.model.bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void delete(int id);
    void update(int id);
}