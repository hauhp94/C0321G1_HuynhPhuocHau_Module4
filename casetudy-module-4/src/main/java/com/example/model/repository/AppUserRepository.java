package com.example.model.repository;

import com.example.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String userName);
    List<AppUser> findAll();

}
