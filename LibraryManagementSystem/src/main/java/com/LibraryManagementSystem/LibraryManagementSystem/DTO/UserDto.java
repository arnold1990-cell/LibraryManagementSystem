package com.LibraryManagementSystem.LibraryManagementSystem.DTO;

import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.MembershipType;
import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.UserRole;

// A "record" is a simple, immutable data class in Java.
// It automatically provides constructor, getters, equals(), hashCode(), and toString().
public record UserDto(
        Long id,                  // Unique identifier for the user
        String name,              // User's full name
        String email,             // User's email address
        UserRole role,            // Role of the user (e.g., ADMIN, MEMBER)
        MembershipType membershipType // Type of membership (e.g., REGULAR, PREMIUM)
) {}
