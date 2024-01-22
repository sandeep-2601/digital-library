package com.example.library.model;

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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String contact;

    @CreationTimestamp
    private Date createdOn;

    @OneToMany(mappedBy = "student")
    private List<Book> bookList;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "my_student")
    private List<Transaction> transaction;

    private Date validity;

}
