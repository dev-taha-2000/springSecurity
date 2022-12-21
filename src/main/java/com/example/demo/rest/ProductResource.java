package com.example.demo.rest;


import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {
    @Autowired
    ProductService productService;
    @PostMapping("/product")
    public void saveProduct(@RequestBody Product product){
        productService.save(product);
    }

    @PostMapping ("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
       return productService.getAll();
    }

}
