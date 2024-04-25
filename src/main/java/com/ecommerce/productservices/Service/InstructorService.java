package com.ecommerce.productservices.Service;

import com.ecommerce.productservices.DTO_s.GetInstructorDto;
import com.ecommerce.productservices.Model_Entity.Batch;
import com.ecommerce.productservices.Model_Entity.Instructor;
import com.ecommerce.productservices.Repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
     * @param name  The name of the instructor.
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
     * This method retrieves a list of instructor details (GetInstructorDto objects) for a given list of instructor IDs (UUIDs).
     *
     * @param uuid A list of UUIDs representing the instructor IDs.
     * @return A list of GetInstructorDto objects containing details for the instructors with the provided IDs.
     */
    public List<GetInstructorDto> getInstructorByIds(List<UUID> uuid) {
        // Find instructors by their IDs using the instructorRepository.
        List<Instructor> instructors = instructorRepository.findAllById(uuid);

        // Create an empty list to store GetInstructorDto objects.
        List<GetInstructorDto> instructorDtos = new ArrayList<>();

        // Loop through each instructor retrieved from the repository.
        for (Instructor instructor : instructors) {
            // Create a new GetInstructorDto object to store the instructor details.
            GetInstructorDto getInstructorDto = new GetInstructorDto();

            // Set the corresponding fields in the GetInstructorDto object with the instructor's details.
            getInstructorDto.setId(instructor.getId());
            getInstructorDto.setName(instructor.getName());
            getInstructorDto.setEmail(instructor.getEmail());

            // Add the GetInstructorDto object containing the instructor details to the list.
            instructorDtos.add(getInstructorDto);
        }

        // Return the list of GetInstructorDto objects containing details for the instructors with the provided IDs.
        return instructorDtos;
    }

    /**
     * This method retrieves a list of instructor details (GetInstructorDto objects) for a given instructor name.
     *
     * @param name The name of the instructor to search for.
     * @return A list of GetInstructorDto objects containing details for instructors with the provided name.
     */
    public List<GetInstructorDto> getInstructorByName(String name) {

        // Find instructors by their name using the instructorRepository.
        List<Instructor> instructors = instructorRepository.findByName(name);

        // Create an empty list to store GetInstructorDto objects.
        List<GetInstructorDto> instructorDtos = new ArrayList<>();

        // Loop through each instructor retrieved from the repository.
        for (Instructor instructor : instructors) {
            // Create a new GetInstructorDto object to store the instructor details.
            GetInstructorDto getInstructorDto = new GetInstructorDto();

            // Set the corresponding fields in the GetInstructorDto object with the instructor's details.
            getInstructorDto.setId(instructor.getId());
            getInstructorDto.setName(instructor.getName());
            getInstructorDto.setEmail(instructor.getEmail());

            // Create empty lists to store batch names and IDs.
            List<String> batchNames = new ArrayList<>();
            List<Long> ids = new ArrayList<>();

            // Loop through each batch the instructor is associated with.
            for (Batch batch : instructor.getBatches()) {
                // Add the batch name and ID to their respective lists.
                batchNames.add(batch.getName());
                ids.add(batch.getId());
            }

            // Set the batch names and IDs in the GetInstructorDto object.
            getInstructorDto.setBatchName(batchNames);
            getInstructorDto.setBatchId(ids);

            // Add the GetInstructorDto object containing the instructor details to the list.
            instructorDtos.add(getInstructorDto);
        }

        // Return the list of GetInstructorDto objects containing details for instructors with the provided name.
        return instructorDtos;
    }
}