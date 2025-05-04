package com.ecommerce.productservices.Repository;

import com.ecommerce.productservices.Model_Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    Product findByDescription(String description);

    Product findByPriceAndCategory(Double price, String category);
}
