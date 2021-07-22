package com.example.product.model.repository;

import com.example.product.model.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    Product findById(int id);
}

