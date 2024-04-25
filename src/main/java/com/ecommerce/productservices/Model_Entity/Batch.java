package com.ecommerce.productservices.Model_Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * This class represents a Batch entity in the E-commerce application.
 * A batch typically refers to a group of learners enrolled in a specific course
 * or program under the guidance of an instructor.
 */
@Data
@Entity
public class Batch {

    /**
     * Unique identifier for the Batch (primary key).
     */
    @Id
    private long id;

    /**
     * Name of the Batch, which could be a course name, program name,
     * or a combination for identification.
     */
    private String name;

    /**
     * Number of learners enrolled in the Batch.
     */
    private Integer strength;

    /**
     * The Instructor associated with the Batch. This represents a ManyToOne relationship,
     * where one Instructor can be associated with multiple Batches.
     * The `@ManyToOne` annotation establishes this relationship.
     */
    @ManyToOne
    private Instructor instructor;
}
