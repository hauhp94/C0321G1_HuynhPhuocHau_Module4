package com.example.model.service;


import com.example.model.entity.Service;

import java.util.List;

public interface ServiceService  {
    void save(Service service);
    List<Service> findAll();

}
