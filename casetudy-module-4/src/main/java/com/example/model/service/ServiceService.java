package com.example.model.service;


import com.example.model.entity.Customer;
import com.example.model.entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceService  {
    void save(Service service);
    List<Service> findAll();
    void remove(int id) throws SQLException;


    Service findById(int id);

}
