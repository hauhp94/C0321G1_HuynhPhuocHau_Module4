package com.codegym.blog.model.service;


import com.codegym.blog.model.bean.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();


    void save(Blog blog);

    void remove(Long id);

    Blog findByNameContaining(String name);

    Blog findById(Long id);

}