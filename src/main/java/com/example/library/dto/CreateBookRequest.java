package com.example.library.dto;

import com.example.library.model.enums.Genre;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CreateBookRequest {
    private String name;
    private Genre genre;
    private CreateAuthorRequest author;
}
