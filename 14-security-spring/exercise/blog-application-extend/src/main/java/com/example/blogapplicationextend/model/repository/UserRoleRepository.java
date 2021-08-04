package com.example.blogapplicationextend.model.repository;


import com.example.blogapplicationextend.model.bean.AppUser;
import com.example.blogapplicationextend.model.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
List<UserRole> findByAppUser(AppUser appUser);
}
