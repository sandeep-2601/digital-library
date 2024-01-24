package com.example.library.model;

import com.example.library.model.enums.TransactionStatus;
import com.example.library.model.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalTxnId;

    @CreationTimestamp
    private Date transactionTime;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"transaction"})
    private Book book;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"transaction"})
    private Student student;

    private Double fine;
}
