package com.LibraryManagementSystem.LibraryManagementSystem.repository;

import com.LibraryManagementSystem.LibraryManagementSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface allows Spring Data JPA to automatically provide
// basic CRUD operations (Create, Read, Update, Delete) for User entities.
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository<User, Long> means:
    // - User = the entity class this repository manages
    // - Long = the type of the primary key (id) of User
}
