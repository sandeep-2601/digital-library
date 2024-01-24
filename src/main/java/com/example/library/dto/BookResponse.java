package com.example.library.dto;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookResponse {
    private String name;
    private Genre genre;
    private int pages;
    private String author;
    private Date createdOn;
    private Date updateOn;

    public static BookResponse from(Book book) {
        if (book == null)
            return null;
        return BookResponse.builder()
                .author(book.getAuthor().getName())
                .name(book.getName())
                .pages(book.getPages())
                .genre(book.getGenre())
                .createdOn(book.getCreatedOn())
                .updateOn(book.getUpdateOn())
                .build();
    }
}
