package com.example.shopping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Product {
    @Id
    @Column
    private int productId;

    @Column
    private String productName;

    @Column
    private String productCategory;

    @Column
    private double productPrice;
}
