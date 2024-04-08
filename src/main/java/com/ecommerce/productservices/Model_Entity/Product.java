package com.ecommerce.productservices.Model_Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;

}