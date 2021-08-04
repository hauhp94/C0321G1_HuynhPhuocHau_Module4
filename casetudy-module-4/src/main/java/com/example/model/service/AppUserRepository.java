package com.example.model.service;

import com.example.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
AppUser findByUsername(String userName);
}
