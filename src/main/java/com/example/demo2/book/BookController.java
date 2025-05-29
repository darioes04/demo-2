package com.example.demo2.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://spiffy-douhua-1e2552.netlify.app")
@RestController
@RequestMapping("api/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/books/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return bookService.getBookByIsbn(isbn);
    }

    @PostMapping("/books")
    public Book newBook(@RequestBody Book book){
        Book response = bookService.newBook(book);
        System.out.println(response);
        return response;
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long id){
        System.out.println("Petición DELETE recibida para ID: " + id);
        bookService.deleteBook(id);
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }


}
