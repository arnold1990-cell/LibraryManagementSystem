package com.LibraryManagementSystem.LibraryManagementSystem.repository;

import com.LibraryManagementSystem.LibraryManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {
}
