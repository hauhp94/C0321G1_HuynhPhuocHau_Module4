package com.example.product.model.service;



import com.example.product.model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);
    List<Product> findByName(String name);


    void update(int id, Product product);

    void remove(int id);
}
