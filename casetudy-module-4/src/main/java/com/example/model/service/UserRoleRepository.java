package com.example.model.service;

import com.example.model.entity.AppUser;
import com.example.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByAppUser(AppUser appUser);
}