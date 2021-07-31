package com.example.blogapplicationextend.model.service;


import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.bean.Category;
import com.example.blogapplicationextend.model.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByCategory(Category category,Pageable pageable) {
        return blogRepository.findAllByCategory(category,pageable);
    }

    @Override
    public List<Blog> findAllByBlogNameContaining(String blogName) {
        return blogRepository.findAllByBlogNameContaining(blogName);
    }
}
