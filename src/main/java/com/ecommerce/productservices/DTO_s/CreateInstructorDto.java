package com.ecommerce.productservices.DTO_s;

import lombok.Data;

/**
 * This class represents a Data Transfer Object (DTO) specifically designed for creating new Instructor entities.
 * It captures the essential data required for instructor creation, promoting separation of concerns and data validation.
 *
 * DTOs are commonly used to transfer data between layers of an application, such as between the service layer
 * and the presentation layer (e.g., API requests). They typically only contain fields for data transfer,
 * and do not include any business logic.
 */
@Data
public class CreateInstructorDto {

    /**
     * The name of the instructor to be created. This field is mandatory.
     */
    private String name;

    /**
     * The email address of the instructor to be created. This field should be unique within the system
     * and is mandatory.
     */
    private String email;
}
