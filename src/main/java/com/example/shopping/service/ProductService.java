package com.example.shopping.service;

import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public void insert(Product product){
        productRepo.save(product);
    }

    public void delete(int productId){
        productRepo.deleteById(productId);
    }

    public void update(Product product){

        productRepo.save(product);
    }

    public List<Product> listAll(){
        List<Product> products = new ArrayList<Product>();
        productRepo.findAll().forEach(product -> products.add(product));
        return products;
    }
    public Optional<Product> getById(int productId){
        return productRepo.findById(productId);
    }

}
