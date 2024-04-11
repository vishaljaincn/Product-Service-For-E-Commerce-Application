package com.ecommerce.productservices.DTO_s;

// This package contains Data Transfer Objects (DTOs) used for transferring product information.

import lombok.Data; // Lombok annotation for generating boilerplate getter, setter, and toString methods

/**
 * This class represents a Data Transfer Object (DTO) for product data.
 * DTOs are typically used to transfer data between layers of an application,
 * such as between a service layer and a presentation layer (e.g., an API controller).
 * DTOs often contain a subset of the data from a full model entity class,
 * improving efficiency and reducing the amount of data transferred.
 */
@Data
public class GetProductDto {

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The price of the product.
     */
    private Double price;

    /**
     * The URL of the product image.
     */
    private String imageUrl;
}
