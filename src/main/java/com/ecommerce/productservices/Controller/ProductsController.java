package com.ecommerce.productservices.Controller;

import com.ecommerce.productservices.DTO_s.GetProductDto;
import com.ecommerce.productservices.Exceptions.NotFoundException;
import com.ecommerce.productservices.Model_Entity.Product;
import com.ecommerce.productservices.Service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class acts as a REST API controller for managing products within the e-commerce application.
 * It exposes endpoints for fetching individual products, retrieving all products, creating new products, and updating products.
 */
@RestController
@RequestMapping("/productsdb")  // Base URI for all product-related requests
public class ProductsController {
    private final Logger logger = LoggerFactory.getLogger(ProductsController.class);
    private final ProductsService productsService;

    /**
     * Constructor to inject ProductService dependency.
     *
     * @param productsService The product service to be used by this controller.
     */
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
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
    @GetMapping("/displaydummyproduct/{id}/{name}")  // Notice proper indentation
    public String display_the_product_with_id_name_category_just_to_know_how_PathVariable_works(
            @PathVariable("id") Long id,
            @PathVariable("name") String name,
            @RequestParam("category") String category) {
        return "Here's your product " + id + " " + name + " " + category;
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product to retrieve.
     * @return A GetProductDto object representing the retrieved product.
     * @throws NotFoundException If the product with the provided ID is not found.
     */
    @GetMapping("/getproductbyId/{id}")
    public @ResponseBody GetProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productsService.getProductById(id);
    }

    /**
     * Retrieves all available products in the system.
     *
     * @return A list of GetProductDto objects representing all products.
     */
    @GetMapping("/getallproducts")
    public @ResponseBody List<GetProductDto> getAllProducts() {
        logger.info("hi bro");
        return productsService.getAllProducts();
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

    /**
     * Updates an existing product based on the provided product information in the request body (JSON format).
     *
     * @param id      The unique identifier of the product to update.
     * @param product A Product object representing the updated product information.
     * @return The updated Product object.
     * @throws NotFoundException If the product with the provided ID is not found.
     */
    @PutMapping("/updateproduct/{id}")
    public @ResponseBody Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws NotFoundException {
        return productsService.updateProduct(id, product);
    }

    /**
     * Partially updates an existing product based on the provided fields in the request body (JSON format).
     *
     * @param id      The unique identifier of the product to update.
     * @param updates A map of fields and values to update.
     * @return The updated Product object.
     * @throws NotFoundException If the product with the provided ID is not found.
     */
    @PatchMapping("/patchproduct/{id}")
    public @ResponseBody Product patchProduct(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) throws NotFoundException {
        return productsService.patchProduct(id, updates);
    }

    /**
     * Adds around 15 random products to the database.
     *
     * @return A list of the newly created Product objects.
     */
    @PostMapping("/addrandomproducts")
    public @ResponseBody List<Product> addRandomProducts() {
        List<Product> randomProducts = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Product product = new Product();
            product.setTitle("Random Product " + (i + 1));
            product.setDescription("Description for random product " + (i + 1));
            product.setPrice(Double.valueOf(i * 10));
            product.setImage("http://example.com/images/random-product-" + (i + 1) + ".jpg");
            product.setCategory("Category " + (i % 5 + 1));  // Distributing products into 5 categories
            randomProducts.add(product);
        }
        return productsService.addProducts(randomProducts);
    }
}
