package com.ecommerce.productservices.Model_Entity;

import jakarta.persistence.*; // Import all javax persistence annotations
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

/**
 * This class represents a User entity in the E-commerce application.
 * It maps to an "ecommerce_user" table in the database and serves as the base class
 * for other entity types that inherit from it (e.g., `Instructor`).
 * <p>
 * The `@Inheritance(strategy = InheritanceType.JOINED)` annotation specifies a
 * joined table inheritance strategy, where subclasses have their own tables
 * that include columns from the base class table.
 */
@Entity(name = "ecommerce_user")
//@MappedSuperclass // Not used here as inheritance is used
@Getter // Lombok annotation for generating getters for all fields
@Setter // Lombok annotation for generating setters for all fields
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    /**
     * Unique identifier for the User (primary key).
     * Generated using a Universally Unique Identifier (UUID) strategy for better portability and security.
     * A UUID is a 128-bit value that is guaranteed to be nearly unique across space and time.
     * This makes it a good choice for primary keys where you need to avoid collisions.
     */
    @Id
    @UuidGenerator
    private UUID id;

    /**
     * Name of the User.
     */
    private String name;

    /**
     * Email address of the User (unique within the system).
     */
    @Column(unique = true)
    private String email;
}
