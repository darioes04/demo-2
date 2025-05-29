package com.example.demo2.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {


    @Query("SELECT s FROM Book s WHERE s.isbn = ?1")
    Optional<Book> findBookByIsbn(String isbn);

    List<Book> findAllByOrderByTitleAsc();
}
