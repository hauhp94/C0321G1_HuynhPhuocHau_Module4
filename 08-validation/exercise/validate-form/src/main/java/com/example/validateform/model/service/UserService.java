package com.example.validateform.model.service;

import com.example.validateform.model.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    void update(int id, User user);

    void remove(int id);
}
