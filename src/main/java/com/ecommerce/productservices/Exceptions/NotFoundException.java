package com.ecommerce.productservices.Exceptions;

// This package contains custom exception classes specific to the product service.

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception class represents a scenario where a product with the requested ID cannot be found.
 * It inherits from the base `Exception` class and provides a more specific error message.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)// Maps this exception to a 400 Bad Request HTTP status code
public class NotFoundException extends Exception {

    /**
     * Constructor that sets a default error message for the exception.
     */
    public NotFoundException() {
        super("The product ID was not found."); // Informative message explaining the cause
    }
}
