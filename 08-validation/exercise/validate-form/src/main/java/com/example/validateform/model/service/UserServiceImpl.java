package com.example.validateform.model.service;

import com.example.validateform.model.entity.User;
import com.example.validateform.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void remove(int id) {

    }
}
