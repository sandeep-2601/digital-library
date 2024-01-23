package com.example.library.controller;

import com.example.library.dto.BookSearchRequest;
import com.example.library.dto.CreateBookRequest;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/books/")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public Book createBook(@RequestBody CreateBookRequest bookRequest) {
        return bookService.saveBook(bookRequest);
    }

    @GetMapping("{bookId}")
    public Book findBookById(@PathVariable int bookId) {
        return bookService.findBookById(bookId);
    }

    @GetMapping("")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @DeleteMapping("{bookId}")
    public Book deleteBookById(@PathVariable int bookId) {
        return bookService.deleteBookById(bookId);
    }

    @PostMapping("search/")
    public List<Book> searchBook(@RequestBody BookSearchRequest bookSearchRequest) {
        return bookService.searchBooks(bookSearchRequest);
    }

}
