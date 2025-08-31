package com.LibraryManagementSystem.LibraryManagementSystem.repository;

import com.LibraryManagementSystem.LibraryManagementSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
}
