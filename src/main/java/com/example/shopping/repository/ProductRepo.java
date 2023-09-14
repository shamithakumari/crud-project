package com.example.shopping.repository;


import com.example.shopping.model.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer>
{
}
