package com.example.blogapplicationextend.model.repository;


import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByOrderByDateCreate(Pageable pageable);
    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByBlogNameContaining(String blogName, Pageable pageable);

}
