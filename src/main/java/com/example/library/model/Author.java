package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    @Column(unique = true,nullable = false)
    private String email;

    @CreationTimestamp
    private Date addedOn;

    // a new column need not be created just a back reference is enough
    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    List<Book> bookList;
}
