package com.example.blogapplicationextend.model.repository;


import com.example.blogapplicationextend.model.bean.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
AppUser findByUserName(String userName);
}
