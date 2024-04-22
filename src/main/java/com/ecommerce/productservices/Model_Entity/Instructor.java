package com.ecommerce.productservices.Model_Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

/**
 * This class represents an Instructor entity in the E-commerce application.
 * It inherits from the base `User` class, sharing common user attributes like name and email.
 * Additionally, it captures information specific to instructors, such as their salary, skill set,
 * and the list of batches they are associated with.
 */
@Entity
@Data // Lombok annotation for generating getters, setters, equals, hashCode, toString (optional for some IDEs)
public class Instructor extends User {

    /**
     * The base salary of the instructor.
     */
    private Double salary;

    /**
     * The primary skill set of the instructor.
     */
    private String skill;

    /**
     * A list of batches that the instructor is associated with.
     * This relationship is a OneToMany association, where one instructor can teach
     * multiple batches. The `mappedBy` attribute specifies the field in the `Batch`
     * entity that holds the foreign key referencing this instructor.
     * <p>
     * The `CascadeType.REMOVE` cascade type ensures that when an instructor is deleted,
     * all associated batches are also deleted, maintaining data integrity.
     */
    //@OneToMany - just this is also fine(without mentioning cardinality in Batch Table and mappedBy attribute is also not required),
    // By default hibernate will create a mapping table (lookup table) for this
    //IF YOU DON'T WANT TO CREATE A LOOKUP TABLE/MAPPING TABLE DO BELOW
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.REMOVE)
    private List<Batch> batches; // Use plural "batches" for consistency
}


