package com.codegym.blog.model.repository;


import com.codegym.blog.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.BlockingDeque;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findByNameContaining(String name);

    Blog findAllById(int id);

}
