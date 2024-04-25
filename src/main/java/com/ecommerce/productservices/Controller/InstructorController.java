package com.ecommerce.productservices.Controller;

import com.ecommerce.productservices.DTO_s.CreateInstructorDto;
import com.ecommerce.productservices.DTO_s.GetInstructorDto;
import com.ecommerce.productservices.Model_Entity.Instructor;
import com.ecommerce.productservices.Service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * This class defines a RESTful API controller for managing Instructors.
 * It handles requests related to creating and retrieving Instructor entities.
 */
@RestController
@RequestMapping("/instructors") // Base path for all instructor-related endpoints
public class InstructorController {

    private final InstructorService instructorService;

    /**
     * Constructor that injects the InstructorService dependency.
     *
     * @param instructorService The service responsible for Instructor logic.
     */
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    /**
     * Creates a new Instructor based on the provided data in a CreateInstructorDto object.
     * This method expects a POST request to the "/instructors" endpoint with the DTO object
     * included in the request body.
     *
     * @param createInstructorDto The DTO containing name and email for creating the Instructor.
     * @return The newly created Instructor object.
     */
    @PostMapping("")
    public Instructor createInstructor(@RequestBody CreateInstructorDto createInstructorDto) {
        // Delegate logic to service layer and return the created instructor
        return instructorService.createInstructor(createInstructorDto.getName(), createInstructorDto.getEmail());
    }

    /**
     * Retrieves a list of Instructors based on their names.
     * This method expects a GET request to the "/instructors/{name}" endpoint,
     * where "{name}" is a path variable that captures the name to search for.
     *
     * @param name The name to search for instructors (case-sensitive).
     * @return A list of Instructor objects matching the provided name,
     * or an empty list if no matches are found.
     */
    @GetMapping("/{name}")
    public List<GetInstructorDto> getInstructorByName(@PathVariable(name = "name") String name) {
        // Delegate logic to service layer and return the retrieved instructors
        return instructorService.getInstructorByName(name);
    }

    /**
     * Retrieves a list of Instructors based on their UUIDs.
     * This method expects a GET request to the "/instructor" endpoint with a list of UUIDs
     * included in the request body.
     *
     * @param uuid A list of UUIDs to search for instructors.
     * @return A list of Instructor objects matching the provided UUIDs,
     * or an empty list if no matches are found.
     */
    @GetMapping("/instructor")
    public List<GetInstructorDto> getInstructorByUUID(@RequestBody List<UUID> uuid) {
        // Delegate logic to service layer and return the retrieved instructors
        return instructorService.getInstructorByIds(uuid);
    }
}
