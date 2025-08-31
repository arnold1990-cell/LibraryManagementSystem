package com.LibraryManagementSystem.LibraryManagementSystem.controller;

import com.LibraryManagementSystem.LibraryManagementSystem.DTO.BookDto;
import com.LibraryManagementSystem.LibraryManagementSystem.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This annotation tells Spring that this class is a REST controller.
// It will handle HTTP requests and send HTTP responses.
@RestController

// This defines the base URL for all endpoints in this controller.
// All requests will start with "/api/books".
@RequestMapping("/api/books")
public class BookController {

    // This is a service class that contains the business logic for books.
    private final BookService bookService;

    // Constructor injection: Spring will automatically provide an instance of BookService.
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // This method handles GET requests to "/api/books".
    // It returns a list of all books in the system.
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        // Calls the service to get all books and wraps it in a HTTP 200 OK response.
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // This method handles GET requests to "/api/books/{id}".
    // It returns a single book that matches the given ID.
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        // @PathVariable tells Spring to take the {id} from the URL and pass it as a parameter.
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // This method handles POST requests to "/api/books".
    // It adds a new book to the system.
    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
        // @RequestBody tells Spring to convert the JSON from the request body into a BookDto object.
        BookDto saved = bookService.addBook(bookDto);
        // Returns the saved book with HTTP 201 Created status.
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // This method handles PUT requests to "/api/books/{id}".
    // It updates the book with the given ID using the data provided.
    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDto));
    }

    // This method handles DELETE requests to "/api/books/{id}".
    // It deletes the book with the given ID from the system.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        // Returns HTTP 204 No Content to indicate successful deletion with no data.
        return ResponseEntity.noContent().build();
    }
}

