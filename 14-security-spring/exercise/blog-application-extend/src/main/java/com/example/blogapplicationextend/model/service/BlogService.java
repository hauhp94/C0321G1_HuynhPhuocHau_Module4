package com.example.blogapplicationextend.model.service;


import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Page<Blog> findAllByCategory(Category category,Pageable pageable);

    Page<Blog> findAllByBlogNameContaining(String blogName, Pageable pageable);
}
