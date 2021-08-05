package com.example.model.service.implement;

import com.example.model.entity.AppUser;
import com.example.model.repository.AppUserRepository;
import com.example.model.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppUserServiceImpl implements AppUserService {
    @Autowired
    AppUserRepository appUserRepository;
    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}
