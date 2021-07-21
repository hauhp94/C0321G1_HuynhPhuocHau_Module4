package com.codegym.blog.model.service;


import com.codegym.blog.model.bean.Blog;
import com.codegym.blog.model.repository.IBlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
    blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
    blogRepository.delete(findById(id));
    }

    @Override
    public Blog findByNameContaining(String name) {
        return blogRepository.findByNameContaining(name);
    }
}