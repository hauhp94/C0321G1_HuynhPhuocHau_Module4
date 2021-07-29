package com.example.blogapplicationextend.model.service;


import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    List<Blog> findAllByCategory(Category category);

    List<Blog> findAllByBlogNameContaining(String blogName);
}
