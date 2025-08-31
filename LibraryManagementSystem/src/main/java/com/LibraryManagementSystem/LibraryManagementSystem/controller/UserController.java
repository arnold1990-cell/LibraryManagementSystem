package com.LibraryManagementSystem.LibraryManagementSystem.controller;

import com.LibraryManagementSystem.LibraryManagementSystem.DTO.UserDto;
import com.LibraryManagementSystem.LibraryManagementSystem.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This annotation makes this class a REST controller.
// Spring will handle HTTP requests sent to this class.
@RestController

// This sets the base URL for all endpoints in this controller.
// Example: http://localhost:8080/api/users
@RequestMapping("/api/users")
public class UserController {

    // This is the service class that contains the main logic for users.
    private final UserService userService;

    // Constructor injection: Spring automatically provides an instance of UserService.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    // Handles GET requests to "/api/users"
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        // Calls the service to get all users and returns a 200 OK response with the list of users
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    // Handles GET requests to "/api/users/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        // @PathVariable extracts the {id} from the URL and passes it to the service
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Add a new user
    // Handles POST requests to "/api/users"
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        // @RequestBody tells Spring to convert the JSON from the request body into a UserDto object
        UserDto saved = userService.addUser(userDto);
        // Returns the saved user with HTTP 201 Created status
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Update an existing user
    // Handles PUT requests to "/api/users/{id}"
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        // Calls the service to update the user and returns the updated user with 200 OK
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    // Delete a user
    // Handles DELETE requests to "/api/users/{id}"
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Calls the service to delete the user
        userService.deleteUser(id);
        // Returns HTTP 204 No Content to indicate deletion was successful
        return ResponseEntity.noContent().build();
    }
}
