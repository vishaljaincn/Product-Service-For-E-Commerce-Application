package com.ecommerce.productservices.DTO_s;

import lombok.Data;

/**
 * This class defines a Data Transfer Object (DTO) used specifically for creating new User objects.
 * It captures the essential data required for User creation, promoting better separation of concerns.
 */
@Data
public class CreateUserDto {

    /**
     * The name of the User to be created.
     */
    private String name;

    /**
     * The email address of the User to be created (must be unique within the system).
     */
    private String email;
}
