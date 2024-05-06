package com.ecommerce.productservices.Repository;

import com.ecommerce.productservices.Model_Entity.GenericProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository and provides methods for performing CRUD operations
 * on GenericProduct entities in the database. It also offers pagination capabilities for retrieving
 * product data in manageable chunks.
 */
public interface GenericProductRepository extends JpaRepository<GenericProduct, Long> {

    /**
     * Retrieves a page of all GenericProduct entities from the database, applying pagination based on the provided Pageable object.
     *
     * @param pageable Defines the page number, size, and sorting criteria for the retrieved data.
     * @return A Page object containing a list of GenericProduct entities within the specified page.
     */
    Page<GenericProduct> findAll(Pageable pageable);

    /**
     * Retrieves a page of GenericProduct entities whose names partially match the given search string,
     * applying pagination based on the provided Pageable object.
     *
     * @param name     The search string to match against product names (case-insensitive).
     * @param pageable Defines the page number, size, and sorting criteria for the retrieved data.
     * @return A Page object containing a list of GenericProduct entities whose names partially match the search string,
     * within the specified page.
     */
    Page<GenericProduct> findAllByNameContaining(String name, Pageable pageable);
}
