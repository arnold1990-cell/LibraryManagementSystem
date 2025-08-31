package com.LibraryManagementSystem.LibraryManagementSystem.Mapper;


import com.LibraryManagementSystem.LibraryManagementSystem.DTO.BookDto;
import com.LibraryManagementSystem.LibraryManagementSystem.Model.Book;

public class BookMapper {

    // Convert Entity -> DTO
    public static BookDto toDTO(Book book) {
        if (book == null) return null;
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getBookStatus(),
                book.getPublishedDate()
        );
    }

    // Convert DTO -> Entity
    public static Book toEntity(BookDto dto) {
        if (dto == null) return null;
        Book book = new Book();
        book.setId(dto.id());
        book.setTitle(dto.title());
        book.setAuthor(dto.author());
        book.setGenre(dto.genre());
        book.setBookStatus(dto.status());
        book.setPublishedDate(dto.publishedDate());
        return book;
    }
}
