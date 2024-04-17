package com.ecommerce.productservices.Service;

import com.ecommerce.productservices.Model_Entity.User;
import com.ecommerce.productservices.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * This class handles User management functionalities within the e-commerce application.
 */
@Service
public class UserService {

    /**
     * Injected dependency of UserRepository. This class provides methods to interact with User data stored in the database.
     */
    private final UserRepository userRepository;

    /**
     * Constructor to inject the UserRepository dependency.
     *
     * @param userRepository The UserRepository instance used by this service to access User data.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new User and saves it to the database.
     *
     * @param name  The name of the User.
     * @param email The email address of the User (must be unique within the system).
     * @return The newly created User object.
     */
    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    /**
     * Retrieves a User from the database based on their name.
     *
     * @param name The name of the User to retrieve.
     * @return The User object if found in the database, throws an exception if not found.
     * @throws NoSuchElementException If no User is found with the provided name.
     */
    public User getUserByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("User not found with name: " + name));
    }
}
