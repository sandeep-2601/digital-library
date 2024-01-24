package com.example.library.controller;

import com.example.library.dto.BookResponse;
import com.example.library.dto.BookSearchRequest;
import com.example.library.dto.CreateBookRequest;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public BookResponse createBook(@RequestBody CreateBookRequest bookRequest) {
        Book book = bookService.saveBook(bookRequest);
        return BookResponse.from(book);
    }

    @GetMapping("/{bookId}")
    public BookResponse findBookById(@PathVariable int bookId) {
        Book book = bookService.findBookById(bookId);
        return BookResponse.from(book);
    }

    @GetMapping("")
    public List<BookResponse> findAllBooks() {
        List<BookResponse> bookResponsesList = new ArrayList<>();
        List<Book> bookList = bookService.findAllBooks();

        bookList.forEach(book -> {
            bookResponsesList.add(BookResponse.from(book));
        });
        return bookResponsesList;
    }

    @DeleteMapping("/{bookId}")
    public BookResponse deleteBookById(@PathVariable int bookId) {
        Book book = bookService.deleteBookById(bookId);
        return BookResponse.from(book);
    }

    @PostMapping("/search")
    public List<BookResponse> searchBook(@RequestBody BookSearchRequest bookSearchRequest) {
        List<BookResponse> bookResponsesList = new ArrayList<>();
        List<Book> bookList = bookService.searchBooks(bookSearchRequest);

        bookList.forEach(book -> {
            bookResponsesList.add(BookResponse.from(book));
        });
        return bookResponsesList;
    }

}
