package com.example.demo.service;

import com.example.demo.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void save(Product product);
    void delete(Long id);
    List<Product> getAll();
}
