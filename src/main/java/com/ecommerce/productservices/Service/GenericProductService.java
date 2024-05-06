package com.ecommerce.productservices.Service;

import com.ecommerce.productservices.Model_Entity.GenericProduct;
import com.ecommerce.productservices.Repository.GenericProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenericProductService {

    private final GenericProductRepository genericProductRepository;

    // Constructor injection for the repository
    public GenericProductService(GenericProductRepository genericProductRepository) {
        this.genericProductRepository = genericProductRepository;
    }

    // Array of sample product names
    private static final String[] PRODUCT_NAMES = {
            "TV", "Headphones", "Smartphone", "Laptop", "Tablet",
            "Camera", "Speaker", "Drone", "Gaming Console", "Smartwatch",
            "Fitness Tracker", "External Hard Drive", "Monitor", "Router",
            "Printer", "Keyboard", "Mouse", "Earphone", "Projector", "Desk"
    };

    // Method to generate sample product data
    public String generateProductData() {
        List<GenericProduct> productList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            // Selecting a random product name from the array
            String productName = PRODUCT_NAMES[i];
            // Generating a random price
            int price = random.nextInt(10000);

            // Creating a new GenericProduct instance with the generated name and price
            GenericProduct genericProduct = new GenericProduct(productName, price);
            // Adding the product to the list
            productList.add(genericProduct);
        }

        // Saving all generated products to the database
        genericProductRepository.saveAll(productList);

        // Returning a message indicating that all products were generated
        return "All the Products got generated";
    }

    // Method to search and retrieve all products
    public List<GenericProduct> searchProducts() {
        return genericProductRepository.findAll();
    }

    // Method to search and retrieve products with pagination and sorting
    public Page<GenericProduct> searchProductsByPagination(int pageNumber, int pageSize, String sorting) {
        return switch (sorting) {
            case "id-asc" -> genericProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id")
            );
            case "name-desc" -> genericProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "name")
            );
            default -> genericProductRepository.findAll(
                    PageRequest.of(pageNumber, pageSize)
            );
        };
    }

    // Method to search and retrieve products containing a specific name with pagination and sorting
    public Page<GenericProduct> searchProductsByPaginationContainingName(String query, int pageNumber, int pageSize, String sorting) {
        return switch (sorting) {
            case "id-asc" -> genericProductRepository.findAllByNameContaining(query,
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id")
            );
            case "name-desc" -> genericProductRepository.findAllByNameContaining(query,
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "name")
            );
            case "name-asc" -> genericProductRepository.findAllByNameContaining(query,
                    PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name")
            );
            default -> genericProductRepository.findAllByNameContaining(query,
                    PageRequest.of(pageNumber, pageSize)
            );
        };
    }
}
