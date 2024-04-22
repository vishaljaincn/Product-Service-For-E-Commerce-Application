package com.ecommerce.productservices.Service;

import com.ecommerce.productservices.Model_Entity.Instructor;
import com.ecommerce.productservices.Repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class provides services related to Instructor entities.
 * It interacts with the InstructorRepository to perform CRUD operations
 * (Create, Read, Update, Delete) on Instructor data.
 */
@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    /**
     * Constructor that injects the InstructorRepository dependency.
     *
     * @param instructorRepository The repository for interacting with Instructor entities.
     */
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    /**
     * Creates a new Instructor entity with the provided name, email,
     * a default salary of 20000.0, and a default skill of "Backend".
     *
     * @param name The name of the instructor.
     * @param email The email address of the instructor.
     * @return The newly created Instructor object.
     */
    public Instructor createInstructor(String name, String email) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setSalary(20000.0); // Default salary
        instructor.setSkill("Backend"); // Default skill

        instructorRepository.save(instructor);
        return instructor;
    }

    /**
     * Retrieves a list of Instructor entities based on their name.
     * This method delegates the search functionality to the InstructorRepository's
     * `findByName` method.
     *
     * @param name The name to search for (case-sensitive).
     * @return A list of Instructors matching the provided name,
     *         or an empty list if no matches are found.
     */
    public List<Instructor> getInstructorByName(String name) {
        return instructorRepository.findByName(name);
    }
}
