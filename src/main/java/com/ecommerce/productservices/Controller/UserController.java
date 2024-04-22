package com.ecommerce.productservices.Controller;

import com.ecommerce.productservices.DTO_s.CreateUserDto;
import com.ecommerce.productservices.Model_Entity.User;
import com.ecommerce.productservices.Service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * This class defines the RESTful API endpoints for managing Users within the E-commerce application.
 * It utilizes Spring annotations to handle incoming HTTP requests and interacts with the `UserService`
 * to perform user creation and retrieval operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor that injects the `UserService` dependency.
     *
     * @param userService The service responsible for user logic and interaction with the data layer.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new User entity in the system based on the information provided in the request body.
     * This endpoint expects a POST request with a valid JSON representation of the `CreateUserDto` object
     * containing user details like name and email.
     *
     * @param createUserDto The DTO object containing user data (name and email).
     * @return The newly created User object upon successful creation.
     * @throws Exception If an error occurs during user creation, a general exception is thrown.
     *                   Consider using more specific exceptions (e.g., `UserAlreadyExistsException`)
     *                   for better error handling and client feedback.
     */
    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto createUserDto) throws Exception {
        return userService.createUser(createUserDto.getName(), createUserDto.getEmail());
    }

    /**
     * Retrieves a User entity from the system based on the provided name path variable.
     * This endpoint expects a GET request with a name specified in the "{name}" path variable.
     *
     * @param name The name of the user to retrieve.
     * @return The User object matching the provided name, or null if not found.
     * Consider returning an appropriate HTTP status code (e.g., `HttpStatus.NOT_FOUND`)
     * to indicate the user wasn't found.
     */
    @GetMapping("/{name}")
    public User getUserByName(@PathVariable(value = "name") String name) {
        User user = userService.getUserByName(name);
        if (user == null) {
            // Handle user not found scenario (e.g., return 404 Not Found)
            return null;
        }
        return user;
    }
}
