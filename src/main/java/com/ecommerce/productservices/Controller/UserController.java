package com.ecommerce.productservices.Controller;

import com.ecommerce.productservices.DTO_s.CreateUserDto;
import com.ecommerce.productservices.Model_Entity.User;
import com.ecommerce.productservices.Service.UserService;
import org.springframework.web.bind.annotation.*;


/**
 * This class defines the REST API endpoints for managing users.
 * It uses Spring annotations to handle incoming HTTP requests and interacts with the UserService to perform user-related operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor to inject the UserService dependency.
     *
     * @param userService The UserService instance used to interact with the user data layer.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This method creates a new user based on the information provided in the CreateUserDto object.
     * The request body should contain a valid JSON representation of the CreateUserDto object.
     *
     * @param createUserDto The CreateUserDto object containing user information like name and email.
     * @return The newly created User object.
     */
    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto.getName(), createUserDto.getEmail());
    }

    /**
     * This method retrieves a user based on the provided name path variable.
     *
     * @param name The name of the user to retrieve.
     * @return The User object with the matching name, or null if not found.
     */
    @GetMapping("/{name}")
    public User getUserByName(@PathVariable(name = "name") String name) {
        return userService.getUserByName(name);
    }
}
