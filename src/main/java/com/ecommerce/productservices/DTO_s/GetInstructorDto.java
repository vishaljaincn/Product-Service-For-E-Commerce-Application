package com.ecommerce.productservices.DTO_s;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * This DTO (Data Transfer Object) class represents the data returned when fetching an Instructor.
 * It includes properties for the instructor's ID, name, email, and potentially information about
 * the batches they are associated with (batch names and IDs).
 */
@Getter
@Setter
public class GetInstructorDto {

    /**
     * Unique identifier for the Instructor.
     */
    private UUID id;

    /**
     * Name of the Instructor.
     */
    private String name;

    /**
     * Email address of the Instructor.
     */
    private String email;

    /**
     * List of names of the batches the Instructor is associated with.
     */
    private List<String> batchName;

    /**
     * List of IDs of the batches the Instructor is associated with.
     */
    private List<Long> batchId;
}
