package com.LibraryManagementSystem.LibraryManagementSystem.services;

import com.LibraryManagementSystem.LibraryManagementSystem.DTO.UserDto;
import com.LibraryManagementSystem.LibraryManagementSystem.Mapper.UserMapper;
import com.LibraryManagementSystem.LibraryManagementSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Marks this class as a Spring service (business logic layer)
@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection: Spring automatically provides the repository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<UserDto> getAllUsers() {
        // findAll() retrieves all User entities from the database
        // map() converts each User to UserDto
        // collect() gathers results into a list
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get a single user by ID
    public UserDto getUserById(Long id) {
        // findById() returns an Optional; convert to DTO if present
        // otherwise throw an exception if user not found
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // Add a new user
    public UserDto addUser(UserDto userDto) {
        var user = UserMapper.toEntity(userDto); // Convert DTO to entity
        return UserMapper.toDTO(userRepository.save(user)); // Save to database and return DTO
    }

    // Update an existing user
    public UserDto updateUser(Long id, UserDto userDto) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        // Update fields from DTO
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setUserRole(userDto.role());
        user.setMembershipType(userDto.membershipType());

        return UserMapper.toDTO(userRepository.save(user)); // Save changes and return DTO
    }

    // Delete a user
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id " + id); // Error if user does not exist
        }
        userRepository.deleteById(id); // Delete from database
    }
}
