package com.example.model.service;

import com.example.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Integer id);
    Page<Book> findAllByNameContaining(String name, Pageable pageable);

    void save(Book book);
}
