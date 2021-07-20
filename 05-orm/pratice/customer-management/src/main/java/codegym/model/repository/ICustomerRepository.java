package codegym.model.repository;


import codegym.model.bean.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void delete(int id);

    void update(int id);
}