package com.example.model.service;

import com.example.model.bean.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 11", 12000, "hang moi", "Apple"));
        products.put(2, new Product(2, "iPhone 12", 15000, "hang moi", "Apple"));
        products.put(3, new Product(3, "iPhone X", 7000, "hang dung", "Apple"));
        products.put(4, new Product(4, "Nokia 9", 6000, "hang dep", "MicroftSoft"));
        products.put(5, new Product(5, "Samsung 11", 5000, "hang cu", "SamSung Company"));
        products.put(6, new Product(6, "Vsmart 7", 4000, "hang moi", "Vin Group"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = this.findAll();
        List<Product> productListByName = new ArrayList<>();

        for (Product product : productList) {
//            Matcher matcher = Pattern.compile(name).matcher(product.getName());
            if (product.getName().matches(name)) {
                productListByName.add(product);
            }
        }
        return productListByName;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
