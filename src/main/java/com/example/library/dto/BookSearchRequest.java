package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookSearchRequest {
    @NotBlank
    private String key;
    @NotBlank
    private String value;
//    @NotBlank
//    private String operator;
    private static Map<String,List<String>> keyOperatorMap = new HashMap<>();

    static {
        keyOperatorMap.put("author", Arrays.asList("=","like"));
        keyOperatorMap.put("pages", Arrays.asList("=",">=","<="));
        keyOperatorMap.put("genre", Arrays.asList("=","!="));
        keyOperatorMap.put("name", Arrays.asList("=","like"));
    }

    public boolean isValid() {
        return  keyOperatorMap.containsKey(key);
//        return keyOperatorMap.get(key).contains(operator);
    }
}
