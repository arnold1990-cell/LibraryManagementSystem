package com.LibraryManagementSystem.LibraryManagementSystem.services;



import com.LibraryManagementSystem.LibraryManagementSystem.DTO.BookDto;
import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.BookStatus;
import com.LibraryManagementSystem.LibraryManagementSystem.Mapper.BookMapper;
import com.LibraryManagementSystem.LibraryManagementSystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get book by ID
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    // Add a new book
    public BookDto addBook(BookDto bookDto) {
        var book = BookMapper.toEntity(bookDto);
        book.setBookStatus(BookStatus.AVAILABLE); // default status
        return BookMapper.toDTO(bookRepository.save(book));
    }

    // Update a book
    public BookDto updateBook(Long id, BookDto bookDto) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        // Update fields from DTO
        book.setTitle(bookDto.title());
        book.setAuthor(bookDto.author());
        book.setGenre(bookDto.genre());
        book.setBookStatus(bookDto.status());
        book.setPublishedDate(bookDto.publishedDate());

        return BookMapper.toDTO(bookRepository.save(book));
    }

    // Delete a book
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id " + id);
        }
        bookRepository.deleteById(id);
    }
}
