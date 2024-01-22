package com.example.library.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CreateAuthorRequest {
    private String name;
    private String country;

}
