package com.ecommerce.productservices.Repository;

import com.ecommerce.productservices.Model_Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * This interface defines the repository for Instructor entities.
 * It extends JpaRepository, which provides basic CRUD operations (Create, Read, Update, Delete)
 * for JPA persistence.
 * <p>
 * The `findByName` method allows you to retrieve a list of Instructors
 * based on their name.
 */
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, UUID> {

    /**
     * Finds a list of Instructors by their name.
     *
     * @param name The name to search for (case-sensitive).
     * @return A list of Instructors matching the provided name,
     * or an empty list if no matches are found.
     */
    List<Instructor> findByName(String name);

}
