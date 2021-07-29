package com.example.blogapplicationextend.model.repository;


import com.example.blogapplicationextend.model.bean.Blog;
import com.example.blogapplicationextend.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    List<Blog> findAllByOrderByDateCreate();
    List<Blog> findAllByCategory(Category category);

    List<Blog> findAllByBlogNameContaining(String blogName);

}
