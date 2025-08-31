package com.LibraryManagementSystem.LibraryManagementSystem.repository;

import com.LibraryManagementSystem.LibraryManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface allows Spring Data JPA to automatically provide
// basic CRUD operations (Create, Read, Update, Delete) for Book entities.
public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository<Book, Long> means:
    // - Book = the entity class this repository manages
    // - Long = the type of the primary key (id) of Book
}
