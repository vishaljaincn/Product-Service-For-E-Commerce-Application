package com.ecommerce.productservices.Repository;

import com.ecommerce.productservices.Model_Entity.Product;
import com.ecommerce.productservices.Repository.Projections.ProductNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    ProductNameProjection findNameById(Long id);
}
