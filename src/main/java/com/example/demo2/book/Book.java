package com.example.demo2.book;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",          // Nombre interno en Java (referencia)
            sequenceName = "sequence_name",  // Nombre REAL de la secuencia en la BBDD
            allocationSize = 1               // Cuánto se incrementa cada vez (normalmente 1)
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    private Long id;
    private String title;
    private String isbn;
    private LocalDate publishedDate;
    private String author;



    public Book(String title, String isbn, LocalDate publishedDate, String author) {
        this.title = title;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.author = author;
    }

    public Book(Long id, String title, String isbn, LocalDate publishedDate, String author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.author = author;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
