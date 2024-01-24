package com.example.library.model;

import com.example.library.model.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int pages;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"bookList"})
    private Author author;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updateOn;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties({"book","student"})
    private List<Transaction> transaction;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"bookList","transaction"})
    private Student student;


}
