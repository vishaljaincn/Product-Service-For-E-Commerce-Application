package com.ecommerce.productservices.Repository;

import com.ecommerce.productservices.Model_Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface defines a repository for accessing and managing User entities
 * within the product services application. It extends JpaRepository, providing
 * essential CRUD operations and additional functionality for working with User data.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a User entity by its name (username, etc.).
     * Returns an Optional object containing the User if found,
     * or Optional.empty() if no User is found with the specified name.
     *
     * @param name The name (username, etc.) of the User to find.
     * @return An Optional containing the User or Optional.empty() if not found.
     */
    Optional<User> findByName(String name);

}