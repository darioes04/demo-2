package com.example.demo2.book;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooks() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Libro con id " + id + " no encontrado"));
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn)
                .orElseThrow(() -> new IllegalStateException("Libro con isbn " + isbn + " no encontrado"));
    }


    public Book newBook(Book book) {
        bookRepository.findBookByIsbn(book.getIsbn())
                .ifPresent(s -> {
                    throw new IllegalStateException("isbn " + book.getIsbn() + " ya registrado");
                });
        return bookRepository.save(book);

    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book updateBook(Book book) {
        Book bookToUpdate = bookRepository.findById(book.getId())
                .orElseThrow(() -> new IllegalStateException("Libro con id " + book.getId() + " no encontrado"));
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setPublishedDate(book.getPublishedDate());
        return bookToUpdate;
    }





}
