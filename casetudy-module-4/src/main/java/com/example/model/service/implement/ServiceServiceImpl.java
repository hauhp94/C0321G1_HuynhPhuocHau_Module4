package com.example.model.service.implement;


import com.example.model.repository.ServiceRepository;
import com.example.model.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;


    @Override
    public void save(com.example.model.entity.Service service) {
        serviceRepository.save(service);
    }
}
