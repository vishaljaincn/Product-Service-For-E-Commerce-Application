package com.ecommerce.productservices.Model_Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

/**
 * This class represents an Instructor entity in the E-commerce application.
 * It inherits from the base `User` class (assumed to exist), sharing common user attributes like name and email.
 * Additionally, it captures information specific to instructors.
 */
@Entity
@Data // Lombok annotation for generating getters, setters, equals, hashCode, toString (optional for some IDEs)
public class Instructor extends User {

    /**
     * The base salary of the instructor.
     */
    private Double salary;

    /**
     * The primary skill set of the instructor (e.g., Java development, Web design).
     */
    private String skill;

    /**
     * A list of batches that the instructor is associated with.
     * This relationship represents a OneToMany association, meaning one instructor can teach
     * multiple batches. The `mappedBy` attribute specifies the field in the `Batch`
     * entity that holds the foreign key referencing this instructor.
     * <p>
     * The `CascadeType.REMOVE` cascade type ensures that when an instructor is deleted,
     * all associated batches are also deleted, maintaining data integrity.
     * <p>
     * By default, JPA creates a separate table to map this relationship (often called a join table).
     * However, in this case, we use `@Fetch(FetchMode.JOIN)` to eagerly fetch the associated batches
     * along with the instructor data, avoiding an additional database query. This can be beneficial
     * for performance when you frequently need both the instructor and their associated batches together.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "instructor", cascade = CascadeType.REMOVE)
    @Fetch(FetchMode.JOIN)
    private List<Batch> batches; // Use plural "batches" for consistency
}
