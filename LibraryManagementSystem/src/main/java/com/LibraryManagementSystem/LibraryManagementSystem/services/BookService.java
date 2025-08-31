package com.LibraryManagementSystem.LibraryManagementSystem.services;

import com.LibraryManagementSystem.LibraryManagementSystem.DTO.BookDto;
import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.BookStatus;
import com.LibraryManagementSystem.LibraryManagementSystem.Mapper.BookMapper;
import com.LibraryManagementSystem.LibraryManagementSystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Marks this class as a Spring service, part of the "business logic" layer
@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor injection: Spring provides the repository automatically
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<BookDto> getAllBooks() {
        // findAll() gets all books from the database
        // map each Book entity to BookDto using BookMapper
        // collect results into a list
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get a single book by ID
    public BookDto getBookById(Long id) {
        // findById() returns an Optional; convert to DTO if present, otherwise throw exception
        return bookRepository.findById(id)
                .map(BookMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    // Add a new book
    public BookDto addBook(BookDto bookDto) {
        var book = BookMapper.toEntity(bookDto); // Convert DTO to entity
        book.setBookStatus(BookStatus.AVAILABLE); // Set default status
        return BookMapper.toDTO(bookRepository.save(book)); // Save to database and return DTO
    }

    // Update an existing book
    public BookDto updateBook(Long id, BookDto bookDto) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        // Update fields from DTO
        book.setTitle(bookDto.title());
        book.setAuthor(bookDto.author());
        book.setGenre(bookDto.genre());
        book.setBookStatus(bookDto.status());
        book.setPublishedDate(bookDto.publishedDate());

        return BookMapper.toDTO(bookRepository.save(book)); // Save changes and return DTO
    }

    // Delete a book
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id " + id); // Error if book does not exist
        }
        bookRepository.deleteById(id); // Delete from database
    }
}
