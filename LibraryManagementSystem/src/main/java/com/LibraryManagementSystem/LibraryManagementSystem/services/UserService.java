package com.LibraryManagementSystem.LibraryManagementSystem.services;



import com.LibraryManagementSystem.LibraryManagementSystem.DTO.UserDto;
import com.LibraryManagementSystem.LibraryManagementSystem.Mapper.UserMapper;
import com.LibraryManagementSystem.LibraryManagementSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get user by ID
    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // Add new user
    public UserDto addUser(UserDto userDto) {
        var user = UserMapper.toEntity(userDto);
        return UserMapper.toDTO(userRepository.save(user));
    }

    // Update user
    public UserDto updateUser(Long id, UserDto userDto) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        // Update fields from DTO
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setUserRole(userDto.role());
        user.setMembershipType(userDto.membershipType());

        return UserMapper.toDTO(userRepository.save(user));
    }

    // Delete user
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}
