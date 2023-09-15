package com.example.shopping.service;

import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public void insert(Product product) {
        productRepo.save(product);
    }

    public void delete(int productId) {
        productRepo.deleteById(productId);
    }

    public void update(int id, Product updateProduct) {
        Product currentProduct = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        currentProduct.setProductName(updateProduct.getProductName());
        currentProduct.setProductCategory(updateProduct.getProductCategory());
        currentProduct.setProductPrice(updateProduct.getProductPrice());
        productRepo.save(currentProduct);
    }

    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        products.addAll(productRepo.findAll());
        return products;
    }

    public Optional<Product> getById(int productId) {
        return productRepo.findById(productId);
    }
}
