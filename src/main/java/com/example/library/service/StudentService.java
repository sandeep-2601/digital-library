package com.example.library.service;

import com.example.library.dto.CreateStudentRequest;
import com.example.library.model.Student;
import com.example.library.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(CreateStudentRequest studentRequest) {
        Student student = studentRequest.createEntity();
        return studentRepository.save(student);
    }

    public Student findStudentById(int studentId) {
        return studentRepository.findStudentById(studentId);
    }

    public Student updateStudent(@Valid @RequestBody CreateStudentRequest studentRequest) {
        Student updatedStudent = studentRequest.createEntity();
        return studentRepository.save(updatedStudent);
    }

    public Student deleteStudentById(int studentId) {
        Student student =  studentRepository.findStudentById(studentId);
        if(student != null)
            studentRepository.delete(student);
        return student;
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

}
