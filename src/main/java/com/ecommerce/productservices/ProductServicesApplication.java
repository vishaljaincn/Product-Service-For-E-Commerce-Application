// Package containing the main application class for the product services

package com.ecommerce.productservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class serves as the entry point for the product services application.
 * It utilizes Spring Boot's autoconfiguration capabilities to simplify application setup.
 *
 * @SpringBootApplication annotation enables automatic configuration, component scanning,
 * and property binding features provided by Spring Boot.
 */
@SpringBootApplication
public class ProductServicesApplication {

    public static void main(String[] args) {
        // Run the Spring Boot application
        SpringApplication.run(ProductServicesApplication.class, args);
    }
}

//Below is the swagger documentation link which in turn contains what dependency to put and what
//url to hit to see the API documentation for our project
//https://bell-sw.com/blog/documenting-rest-api-with-swagger-in-spring-boot-3/#mcetoc_1heq9ft3o1h