package com.LibraryManagementSystem.LibraryManagementSystem.Mapper;

import com.LibraryManagementSystem.LibraryManagementSystem.DTO.BookDto;
import com.LibraryManagementSystem.LibraryManagementSystem.Model.Book;

// This class is responsible for converting between Book entity and BookDto.
// Entity = the object used in the database (Book)
// DTO = the object sent to/received from clients (BookDto)
public class BookMapper {

    // Convert Book entity -> BookDto
    public static BookDto toDTO(Book book) {
        if (book == null) return null;  // Return null if input is null
        // Create a new BookDto using values from the Book entity
        return new BookDto(
                book.getId(),          // Book ID
                book.getTitle(),       // Book title
                book.getAuthor(),      // Book author
                book.getGenre(),       // Book genre (enum)
                book.getBookStatus(),  // Book status (enum)
                book.getPublishedDate()// Published date
        );
    }

    // Convert BookDto -> Book entity
    public static Book toEntity(BookDto dto) {
        if (dto == null) return null;  // Return null if input is null
        Book book = new Book();         // Create a new Book entity
        book.setId(dto.id());           // Set ID
        book.setTitle(dto.title());     // Set title
        book.setAuthor(dto.author());   // Set author
        book.setGenre(dto.genre());     // Set genre
        book.setBookStatus(dto.status());// Set status
        book.setPublishedDate(dto.publishedDate()); // Set published date
        return book;                    // Return the entity
    }
}
