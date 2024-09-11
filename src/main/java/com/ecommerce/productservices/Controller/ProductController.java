// Package containing controller classes for the e-commerce product service
package com.ecommerce.productservices.Controller;

import com.ecommerce.productservices.DTO_s.GetProductDto;
import com.ecommerce.productservices.Exceptions.NotFoundException;
import com.ecommerce.productservices.Model_Entity.Product;
import com.ecommerce.productservices.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class acts as a REST API controller for managing products within the e-commerce application.
 * It exposes endpoints for fetching individual products, retrieving all products, and creating new products.
 */
@RestController
@RequestMapping("/products")  // Base URI for all product-related requests
public class ProductController {
    /*
        @Autowired
        private ProductService productService;  -> This can also be used, but spring suggests us to use below
                                                   Constructor based injection
    */
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    /**
     * Constructor to inject ProductService dependency.
     *
     * @param productService The product service to be used by this controller.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * This endpoint demonstrates how to access path variables and request parameters from the URI.
     * It's for illustrative purposes and might not be part of a real product API.
     *
     * @param id       The unique identifier of the product to retrieve.
     * @param name     The name of the product.
     * @param category The category of the product. (Provided as a request parameter)
     * @return A string concatenating the provided information.
     */
//    @GetMapping("/displaydummyproduct/{id}/{name}")  // Notice proper indentation
//    // @PathVariable extracts required variables from the URI path. You can use multiple Path Variables.
//    // @RequestParam allows capturing user input through request parameters.
//    public String display_the_product_with_id_name_category_just_to_know_how_PathVariable_works(
//            @PathVariable("id") Long id,
//            @PathVariable("name") String name,
//            @RequestParam("category") String category) {
//        logger.info("just to check log functionality");
//        return "Here's your product " + id + " " + name + " " + category;
//    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product to retrieve.
     * @return A GetProductDto object representing the retrieved product.
     * @throws NotFoundException If the product with the provided ID is not found.
     */
    @GetMapping("/getproductbyId/{id}")
    public @ResponseBody CompletableFuture<GetProductDto> getProductById(@PathVariable("id") Long id) throws NotFoundException, ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());
        return CompletableFuture.completedFuture(productService.getProductById(id).get());
    }

    /**
     * Retrieves all available products in the system.
     *
     * @return A list of GetProductDto objects representing all products.
     */
    @GetMapping("/getallproducts")
    public @ResponseBody List<GetProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Creates a new product based on the provided product information in the request body (JSON format).
     * <p>
     * (**Note:** This example currently does not persist the created product. Implement logic in ProductService to save the product to the database.)
     *
     * @param product A Product object representing the new product to be created.
     * @return The newly created Product object.
     */
    @PostMapping("/postproduct_dummy_functionality")
    public @ResponseBody Product createProduct(@RequestBody Product product) {
        // Implement logic to persist the product using ProductService
        System.out.println(product.getId());
        System.out.println(product.getTitle());
        System.out.println(product.getDescription());
        System.out.println(product.getImage());
        System.out.println(product.getCategory());
        return product;
    }
}

