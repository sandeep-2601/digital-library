package com.example.library.dto;

import com.example.library.model.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CreateStudentRequest {
    @NotBlank
    private String name;
    private String contact;

    public Student createEntity() {
        return Student.builder()
                .name(name)
                .contact(contact)
                .validity(new Date(System.currentTimeMillis() + 365L *24*60*60*1000))
                .build();
    }
}
