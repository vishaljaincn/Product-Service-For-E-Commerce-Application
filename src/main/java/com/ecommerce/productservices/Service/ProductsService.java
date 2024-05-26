package com.ecommerce.productservices.Service;

import com.ecommerce.productservices.DTO_s.GetProductDto;
import com.ecommerce.productservices.Exceptions.NotFoundException;
import com.ecommerce.productservices.Model_Entity.Product;
import com.ecommerce.productservices.Repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    /**
     * Constructor to inject ProductsRepository dependency.
     *
     * @param productsRepository The product repository to be used by this service.
     */
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product to retrieve.
     * @return A GetProductDto object representing the retrieved product.
     * @throws NotFoundException If the product with the provided ID is not found.
     */
    public GetProductDto getProductById(Long id) throws NotFoundException {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        return convertToDto(product);
    }

    /**
     * Retrieves all available products in the system.
     *
     * @return A list of GetProductDto objects representing all products.
     */
    public List<GetProductDto> getAllProducts() {
        List<Product> products = productsRepository.findAll();
        List<GetProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(convertToDto(product));
        }
        return productDtos;
    }

    /**
     * Creates a new product based on the provided product information.
     *
     * @param product A Product object representing the new product to be created.
     * @return The newly created Product object.
     */
    public Product createProduct(Product product) {
        return productsRepository.save(product);
    }

    /**
     * Updates an existing product based on the provided product information.
     *
     * @param id            The unique identifier of the product to update.
     * @param productDetails A Product object representing the updated product information.
     * @return The updated Product object.
     * @throws NotFoundException If the product with the provided ID is not found.
     */
    public Product updateProduct(Long id, Product productDetails) throws NotFoundException {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        product.setTitle(productDetails.getTitle());
        product.setDescription(productDetails.getDescription());
        product.setImage(productDetails.getImage());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        // Set other fields as needed

        return productsRepository.save(product);
    }

    /**
     * Partially updates an existing product based on the provided fields in the request body (JSON format).
     *
     * @param id      The unique identifier of the product to update.
     * @param updates A map of fields and values to update.
     * @return The updated Product object.
     * @throws NotFoundException If the product with the provided ID is not found.
     */
    public Product patchProduct(Long id, Map<String, Object> updates) throws NotFoundException {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if ("title".equals(key)) {
                product.setTitle((String) value);
            } else if ("description".equals(key)) {
                product.setDescription((String) value);
            } else if ("image".equals(key)) {
                product.setImage((String) value);
            } else if ("category".equals(key)) {
                product.setCategory((String) value);
            } else if ("price".equals(key)) {
                product.setPrice((Double) value);
            } else {
                throw new IllegalArgumentException("Invalid field: " + key);
            }
        }

        return productsRepository.save(product);
    }

    /**
     * Converts a Product entity to a GetProductDto.
     *
     * @param product The Product entity to convert.
     * @return The corresponding GetProductDto.
     */
    private GetProductDto convertToDto(Product product) {
        GetProductDto dto = new GetProductDto();
        dto.setName(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setImageUrl(product.getImage());
        return dto;
    }

    /**
     * Adds a list of products to the database.
     *
     * @param products A list of Product objects to add.
     * @return A list of the newly created Product objects.
     */
    public List<Product> addProducts(List<Product> products) {
        return productsRepository.saveAll(products);
    }
}
