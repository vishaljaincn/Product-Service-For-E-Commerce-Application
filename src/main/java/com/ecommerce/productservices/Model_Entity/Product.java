package com.ecommerce.productservices.Model_Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Fetch;

/**
 * This class represents a product entity within the application domain.
 * It encapsulates essential product information like its unique identifier, title, description,
 * price, image URL, and category.
 */
@Data
@Entity
public class Product {

    /**
     * Unique identifier for the product within the system.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name or title of the product.
     */
    private String title;

    /**
     * A detailed description of the product.
     */
    private String description;

    /**
     * The price of the product, typically represented as a double for decimal values.
     */

    private Double price;

    /**
     * The URL pointing to an image of the product.
     */
    private String image;

    /**
     * The category this product belongs to (e.g., electronics, clothing, etc.).
     */
    private String category;

}
