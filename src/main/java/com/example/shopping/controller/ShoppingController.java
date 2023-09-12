package com.example.shopping.controller;

import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepo;
import com.example.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShoppingController {
    @Autowired
    ProductRepo repo;
    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public void addProduct(Product product){
        productService.insert(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") int id){
        productService.delete(id);
    }
    @PutMapping("/product")
    public void updateProduct(Product product){
        productService.update(product);
    }
    @GetMapping("/products")
    @ResponseBody
    private List<Product> getAllProducts() {
        return productService.listAll();
    }

    @GetMapping ("/product/{id}")
    @ResponseBody
    public Optional<Product> getProduct(@PathVariable("id") int id) {
        return productService.getById(id);
    }
}
