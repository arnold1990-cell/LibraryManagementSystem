package com.LibraryManagementSystem.LibraryManagementSystem.DTO;

import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.BookStatus;
import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.Genre;

import java.time.LocalDate;

public record BookDto(
        Long id,
        String title,
        String author,
        Genre genre,
        BookStatus status,
        LocalDate publishedDate
) {}