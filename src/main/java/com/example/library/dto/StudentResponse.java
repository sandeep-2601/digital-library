package com.example.library.dto;

import com.example.library.model.Student;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class StudentResponse {
    private String name;
    private String contact;
    private Date validity;
    private Double fine;

    public static StudentResponse from(Student student) {
        if (student == null)
            return null;
        return StudentResponse.builder()
                .name(student.getName())
                .contact(student.getContact())
                .fine(student.getFine())
                .validity(student.getValidity())
                .build();
    }
}
