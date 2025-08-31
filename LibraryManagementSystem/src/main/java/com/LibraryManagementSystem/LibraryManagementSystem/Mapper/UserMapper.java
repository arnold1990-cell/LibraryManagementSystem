package com.LibraryManagementSystem.LibraryManagementSystem.Mapper;


import com.LibraryManagementSystem.LibraryManagementSystem.DTO.UserDto;
import com.LibraryManagementSystem.LibraryManagementSystem.Model.User;

public class UserMapper {

    // Convert Entity -> DTO
    public static UserDto toDTO(User user) {
        if (user == null) return null;
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUserRole(),
                user.getMembershipType()
        );
    }

    // Convert DTO -> Entity
    public static User toEntity(UserDto dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.id());
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setUserRole(dto.role());
        user.setMembershipType(dto.membershipType());
        return user;
    }
}
