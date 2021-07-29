package com.example.blogapplicationextend.model.repository;

import com.example.blogapplicationextend.model.bean.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
