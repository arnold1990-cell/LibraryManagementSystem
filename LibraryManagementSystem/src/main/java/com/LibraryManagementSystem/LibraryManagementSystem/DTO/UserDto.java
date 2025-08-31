package com.LibraryManagementSystem.LibraryManagementSystem.DTO;

import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.MembershipType;
import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.UserRole;

public record UserDto(Long id,
                      String name,
                      String email,
                      UserRole role,
                      MembershipType membershipType
) {}