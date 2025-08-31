package com.LibraryManagementSystem.LibraryManagementSystem.Mapper;

import com.LibraryManagementSystem.LibraryManagementSystem.DTO.UserDto;
import com.LibraryManagementSystem.LibraryManagementSystem.Model.User;

// This class converts between User entity and UserDto.
// Entity = object used in the database (User)
// DTO = object sent to or received from clients (UserDto)
public class UserMapper {

    // Convert User entity -> UserDto
    public static UserDto toDTO(User user) {
        if (user == null) return null; // Return null if input is null
        // Create a new UserDto using values from the User entity
        return new UserDto(
                user.getId(),             // User ID
                user.getName(),           // User name
                user.getEmail(),          // User email
                user.getUserRole(),       // User role (enum)
                user.getMembershipType()  // Membership type (enum)
        );
    }

    // Convert UserDto -> User entity
    public static User toEntity(UserDto dto) {
        if (dto == null) return null; // Return null if input is null
        User user = new User();       // Create a new User entity
        user.setId(dto.id());         // Set ID
        user.setName(dto.name());     // Set name
        user.setEmail(dto.email());   // Set email
        user.setUserRole(dto.role()); // Set role
        user.setMembershipType(dto.membershipType()); // Set membership type
        return user;                  // Return the entity
    }
}
