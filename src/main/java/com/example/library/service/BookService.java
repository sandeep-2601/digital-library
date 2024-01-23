package com.example.library.service;

import com.example.library.dto.CreateAuthorRequest;
import com.example.library.dto.CreateBookRequest;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class BookService {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(CreateBookRequest bookRequest) {
        Author author = authorService.saveAuthor(bookRequest.getAuthor());
        Book book = Book.builder().build();
        book.setName(bookRequest.getName());
        book.setGenre(bookRequest.getGenre());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public Book findBookById(int bookId) {
        Optional<Book> book =  bookRepository.findById(bookId);
        return book.orElse(null);
    }

    public Book deleteBookById(int bookId) {
        Book book = findBookById(bookId);
        if(book!=null) bookRepository.delete(book);
        return book;
    }

}
