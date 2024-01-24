package com.example.library.controller;

import com.example.library.model.enums.TransactionType;
import com.example.library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/issue")
    public String createTransaction(
            @RequestParam("bookName") String name,
            @RequestParam("studentId") int studentId
    ) {
        return transactionService.initiateIssueTransaction(name, studentId);
    }

    @GetMapping("/return")
    public String createTransaction(
            @RequestParam("studentId") int studentId,
            @RequestParam("bookId") int bookId
    ) {
        return transactionService.initiateReturnTransaction(studentId,bookId);
    }
}
