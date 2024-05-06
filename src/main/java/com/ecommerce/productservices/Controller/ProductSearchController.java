package com.ecommerce.productservices.Controller;

import com.ecommerce.productservices.Model_Entity.GenericProduct;
import com.ecommerce.productservices.Service.GenericProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductSearchController {

    private final GenericProductService genericProductService;

    public ProductSearchController(GenericProductService genericProductService) {
        this.genericProductService = genericProductService;
    }

    /**
     * Generates sample product data and returns it in the response body.
     *
     * @return ResponseEntity containing the generated product data.
     */
    @GetMapping("/generateSampleData")
    public ResponseEntity generateSampleData() {
        // Return the generated products with a status code of 200 (OK)
        return ResponseEntity.ok(genericProductService.generateProductData());
    }

    /**
     * Retrieves all product data without pagination or sorting.
     *
     * @return ResponseEntity containing a list of all GenericProduct objects.
     */
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<GenericProduct>> getAllProducts() {
        // Retrieve all products from the service layer
        List<GenericProduct> allProducts = genericProductService.searchProducts();
        // Return all products with a status code of 200 (OK)
        return ResponseEntity.ok(allProducts);
    }

    /**
     * Retrieves a paginated and sorted list of all product data.
     *
     * @param pageNumber The page number to retrieve (starting from 0).
     * @param pageSize   Optional: The number of products per page (default 20).
     * @param sort       Optional: The sorting criteria (e.g., "id-asc", "name-desc").
     * @return ResponseEntity containing a Page object with sorted product data.
     */
    @GetMapping("/getAllProductsPaginatedAndSorted")
    public ResponseEntity<Page<GenericProduct>> searchProductsByPage(
            @RequestParam(value = "pageNumber") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
            @RequestParam(value = "sort", required = false, defaultValue = "id-asc") String sort) {
        // Delegate the task of retrieving paginated and sorted products to the service layer
        Page<GenericProduct> productPage = genericProductService.searchProductsByPagination(pageNumber, pageSize, sort);
        // Return the paginated and sorted products with a status code of 200 (OK)
        return ResponseEntity.ok(productPage);
    }

    /**
     * Retrieves a paginated and sorted list of products containing the provided query string in their names.
     *
     * @param query      Required: The query string to search product names.
     * @param pageNumber The page number to retrieve (starting from 0).
     * @param pageSize   Optional: The number of products per page (default 20).
     * @param sort       Optional: The sorting criteria (e.g., "id-asc", "name-desc").
     * @return ResponseEntity containing a Page object with sorted product data matching the query.
     */
    @GetMapping("/searchProductsByNamePaginatedAndSorted")
    public ResponseEntity<Page<GenericProduct>> searchProductsByName(
            @RequestParam(value = "q", required = true) String query,
            @RequestParam(value = "pageNumber") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
            @RequestParam(value = "sort", required = false, defaultValue = "id-asc") String sort) {
        // Delegate the task of searching and sorting products by name to the service layer
        Page<GenericProduct> productPage = genericProductService.searchProductsByPaginationContainingName(query, pageNumber, pageSize, sort);
        // Return the paginated and sorted products matching the query with a status code of 200 (OK)
        return ResponseEntity.ok(productPage);
    }

}
