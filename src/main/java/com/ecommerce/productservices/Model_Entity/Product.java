package com.ecommerce.productservices.Model_Entity;

import lombok.Getter;
import lombok.Setter;

//@Getter and @Setter are annotation belonging to Lombok library, these can be used to automatically
// generate getter and setter methods for fields in a Java class. This can save you a lot of time and
// boilerplate code, especially if you have a lot of fields in your class.
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