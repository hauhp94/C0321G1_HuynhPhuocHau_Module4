package com.example.blogapplicationextend.model.service;


import com.example.blogapplicationextend.model.bean.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
