package com.example.shopping;

import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductTesting {
    @Autowired
    private ProductRepo repo;

    @Test
    @Order(1)
    public void createTest() {
        Product product = Product.builder().productName("pencil").productCategory("stationary").productPrice(50.00).build();

        repo.save(product);
        System.out.println(product.getProductId());
        Assertions.assertThat(product.getProductId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getTest() {
        System.out.println("bbbb");
        Product product = repo.findById(1).get();
        System.out.println("ooooo");
        Assertions.assertThat(product.getProductId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getAllTest() {
        List<Product> products = repo.findAll();
        Assertions.assertThat(products.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateTest() {
        Product product = repo.findById(1).get();
        product.setProductName("book");
        Product updatedproduct = repo.save(product);
        Assertions.assertThat(updatedproduct.getProductName()).isEqualTo("book");
    }

    @Test
    @Order(5)
    public void deleteTest() {
        Product product = repo.findById(1).get();
        repo.delete(product);
        Optional<Product> tempProduct = repo.findByProductName("book");
        Product afterDeleteProduct = null;
        if (!tempProduct.isEmpty()) {
            afterDeleteProduct = tempProduct.get();
        }
        Assertions.assertThat(afterDeleteProduct).isNull();
    }

}
