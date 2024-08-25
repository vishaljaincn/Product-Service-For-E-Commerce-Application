package com.ecommerce.productservices.Service;

import com.ecommerce.productservices.DTO_s.GetProductDto;
import com.ecommerce.productservices.Exceptions.NotFoundException;
import com.ecommerce.productservices.Model_Entity.Product;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    /**
     * Retrieves a product from a 3rd party 'Fake Store API' based on the provided ID.
     * This method throws a `NotFoundException` if the product with the given ID is not found.
     *
     * @param id The ID of the product to retrieve.
     * @return A `GetProductDto` object containing product details.
     * @throws NotFoundException If the product with the given ID is not found in the external API.
     */
    @Async
    public CompletableFuture<GetProductDto> getProductById(Long id) throws NotFoundException {
        System.out.println(Thread.currentThread().getName());
        RestTemplate restTemplate = new RestTemplate(); // Create a RestTemplate instance for making HTTP requests

        String url = "https://fakestoreapi.com/products/" + id; // Construct the API endpoint URL with the product ID
        Product product = restTemplate.getForObject(url, Product.class); // Make a GET request to the external API and map the response to a Product object

        // Removed debugging statement - not required for core functionality

        if (product == null) {
            throw new NotFoundException("product doesn't exist"); // Throw an exception if the product is not found
        }

        // No need to call the DB as we're using an external API (Commented out for clarity)
        // Call the Fake Store API to retrieve product details.
        // https://fakestoreapi.com/products/15

        return CompletableFuture.completedFuture(convertToDto(product)); // Convert the retrieved product to a GetProductDto (potentially lighter weight for response data)
    }

    /**
     * Converts a `Product` object to a `GetProductDto` object.
     * This method maps relevant product properties to the corresponding fields in the DTO.
     *
     * @param product The `Product` object to convert.
     * @return A `GetProductDto` object containing mapped product details.
     */
    private static GetProductDto convertToDto(Product product) {
        GetProductDto obj = new GetProductDto(); // Create a new GetProductDto object

        // Map product properties to GetProductDto fields
        obj.setName(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImageUrl(product.getImage());

        return obj; // Return the converted GetProductDto object
    }

    /**
     * Retrieves all products available from the 3rd party 'Fake Store API'.
     * This method makes a GET request to the API endpoint and converts the response to a list of `GetProductDto` objects.
     *
     * @return A list of `GetProductDto` objects representing all available products.
     */
    public List<GetProductDto> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate(); // Create a RestTemplate instance

        String url = "https://fakestoreapi.com/products"; // API endpoint URL to retrieve all products
        Product[] products = restTemplate.getForObject(url, Product[].class); // Make a GET request and map the response to an array of Product objects

        List<GetProductDto> returnedProducts = new ArrayList<>(); // Create an empty list to store GetProductDto objects

        for (Product product : products) { // Loop through each product in the retrieved array
            returnedProducts.add(convertToDto(product)); // Convert each product to a GetProductDto and add it to the list
        }
        return returnedProducts; // Return the list of GetProductDto objects representing all products
    }
}
