package com.example.model.service.implement;


import com.example.model.repository.ServiceRepository;
import com.example.model.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;


    @Override
    public void save(com.example.model.entity.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<com.example.model.entity.Service> findAll() {
        return serviceRepository.findAllByIsDelete(0);
    }

    @Override
    public void remove(int id) throws SQLException {
        com.example.model.entity.Service service=serviceRepository.findById(id).get();
        service.setIsDelete(1);
        serviceRepository.save(service);
    }

    @Override
    public com.example.model.entity.Service findById(int id) {
        return serviceRepository.findById(id).get();
    }
}
