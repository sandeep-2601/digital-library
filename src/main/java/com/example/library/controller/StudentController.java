package com.example.library.controller;

import com.example.library.dto.BookResponse;
import com.example.library.dto.CreateStudentRequest;
import com.example.library.dto.StudentResponse;
import com.example.library.model.Book;
import com.example.library.model.Student;
import com.example.library.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public StudentResponse createStudent(@RequestBody CreateStudentRequest studentRequest) {
       Student student =  studentService.createStudent(studentRequest);
       return StudentResponse.from(student);
    }
    @GetMapping("/{studentId}")
    public StudentResponse findStudentById(@Valid @PathVariable int studentId) {
        Student student = studentService.findStudentById(studentId);
        return StudentResponse.from(student);
    }
    @PutMapping("")
    public StudentResponse updateStudent(@Valid @RequestBody CreateStudentRequest studentRequest) {
        Student student =  studentService.updateStudent(studentRequest);
        return StudentResponse.from(student);
    }

    @DeleteMapping("/{studentId}")
    public StudentResponse deleteStudent(@Valid @PathVariable int studentId) {
        Student student =  studentService.deleteStudentById(studentId);
        return StudentResponse.from(student);
    }

    @GetMapping("")
    public List<StudentResponse> findAllStudents() {
        List<StudentResponse> studentResponsesList = new ArrayList<>();
        List<Student> studentList = studentService.findAllStudents();

        studentList.forEach(student -> {
            studentResponsesList.add(StudentResponse.from(student));
        });
        return studentResponsesList;
    }
}
