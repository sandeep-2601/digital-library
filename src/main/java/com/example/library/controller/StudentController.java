package com.example.library.controller;

import com.example.library.dto.CreateStudentRequest;
import com.example.library.model.Student;
import com.example.library.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/students/")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public Student createStudent(@RequestBody CreateStudentRequest studentRequest) {
       return studentService.createStudent(studentRequest);
    }
    @GetMapping("{studentId}")
    public Student createStudent(@Valid @PathVariable int studentId) {
        return studentService.findStudentById(studentId);
    }
    @PutMapping("")
    public Student updateStudent(@Valid @RequestBody CreateStudentRequest studentRequest) {
        return studentService.updateStudent(studentRequest);
    }

    @DeleteMapping("{studentId}")
    public Student deleteStudent(@Valid @PathVariable int studentId) {
        return studentService.deleteStudentById(studentId);
    }

}
