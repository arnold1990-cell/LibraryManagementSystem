package com.LibraryManagementSystem.LibraryManagementSystem.Model;

import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.BookStatus;
import com.LibraryManagementSystem.LibraryManagementSystem.ENUMS.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 100)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus bookStatus = BookStatus.AVAILABLE;

    @Column(name = "published_date")
    private LocalDate publishedDate;

}