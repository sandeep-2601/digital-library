package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Student;
import com.example.library.model.Transaction;
import com.example.library.model.enums.TransactionStatus;
import com.example.library.model.enums.TransactionType;
import com.example.library.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${student.books.limit}")
    private int maxBooksLimit;

    @Value("${student.issue.days.limit}")
    private int issueDaysLimit;

    private Transaction createTransaction(TransactionType transactionType, Book book, Student student) {
        String externalTxnId = UUID.randomUUID().toString();
        Transaction transaction = Transaction.builder()
                .transactionTime(new Date())
                .book(book)
                .student(student)
                .transactionType(transactionType)
                .externalTxnId(externalTxnId)
                .transactionStatus(TransactionStatus.PENDING)
                .build();
        transactionRepository.save(transaction);
        return transaction;
    }

    public String recordIssueTransaction(TransactionType transactionType, Book book, Student student) {
        Transaction transaction = createTransaction(transactionType, book, student);
        try {
            if (bookService.findBookById(book.getId()).getStudent() != null) {
                throw new Exception();
            }
            book.setStudent(student);
            bookService.saveBook(book);
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        } catch (Exception ignored) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
        } finally {
            transactionRepository.save(transaction);
        }
        return transaction.getExternalTxnId();
    }

    public String recordReturnTransaction(TransactionType transactionType, Book book, Student student) {
        Transaction transaction = createTransaction(transactionType, book, student);
        try {
            book.setStudent(null);
            bookService.saveBook(book);
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        } catch (Exception ignored) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
        } finally {
            transactionRepository.save(transaction);
        }
        return transaction.getExternalTxnId();
    }

    public String initiateIssueTransaction(String name,
                                           int studentId) {
        Student student = studentService.findStudentById(studentId);
        if (student == null)
            return "Student does not exist";
        Book book = bookService.findBookByName(name);
        if (book == null)
            return "Book does not exist";
        if (book.getStudent() != null)
            return "Book is not available";
        if(student.getFine() != null && student.getFine()>0)
            return "Please clear your fine of " + student.getFine();
        if(student.getBookList()!= null && student.getBookList().size()>maxBooksLimit)
            return "You already reached max books that can be issued please return books to collect new ones";

        return recordIssueTransaction(TransactionType.ISSUE, book, student);
    }
    public String initiateReturnTransaction(int studentId, int bookId) {
        Student student = studentService.findStudentById(studentId);
        if(student == null)
            return "student with the given id does not exist";
        Book book = bookService.findBookById(bookId);
        if(book == null)
            return "Book with the given id does not exist";
        if(book.getStudent().getId() != studentId)
            return "Book is not mapped with the current student";
        return recordReturnTransaction(TransactionType.RETURN,book,book.getStudent());
    }
}
