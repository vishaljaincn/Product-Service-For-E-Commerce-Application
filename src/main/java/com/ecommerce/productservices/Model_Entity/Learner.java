package com.ecommerce.productservices.Model_Entity;

import jakarta.persistence.Entity;
import lombok.Data;

/**
 * This class represents a Learner entity in the E-commerce application.
 * It inherits from the base `User` class, sharing common user attributes
 * like name and email. Additionally, it captures information specific to learners,
 * such as their university and a potential "Points for Special Programs" (PSP) value.
 */
@Entity
@Data
public class Learner extends User {

    /**
     * The university the learner attends (or attended).
     */
    private String university;

    /**
     * Points for Special Programs (PSP) associated with the learner.
     * The exact meaning and usage of PSP would depend on your specific application's logic.
     */
    private Double psp;
}
