package com.LibraryManagementSystem.LibraryManagementSystem.DTO;

import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.BookStatus;
import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.Genre;
import java.time.LocalDate;

// This is a "record" in Java. Records are a simple way to create
// immutable data classes without writing boilerplate code (like getters, setters, constructors).
public record BookDto(
        Long id,             // Unique identifier for the book
        String title,        // The title of the book
        String author,       // The author's name
        Genre genre,         // The genre of the book (e.g., Fiction, Non-Fiction)
        BookStatus status,   // Status of the book (e.g., AVAILABLE, BORROWED)
        LocalDate publishedDate // Date when the book was published
) {}
