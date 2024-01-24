package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("SELECT b FROM  Book b join Author a on b.author=a and a.name LIKE :authorName")
    List<Book> findBooksByAuthorName(@Param("authorName") String name);

    List<Book> findBooksByNameLike(String bookName);

    Book findBookByName(String name);
}
