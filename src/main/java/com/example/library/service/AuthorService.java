package com.example.library.service;


import com.example.library.dto.CreateAuthorRequest;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(CreateAuthorRequest authorRequest) {
        Author author = Author
                .builder()
                .name(authorRequest.getName())
                .country(authorRequest.getName())
                .build();
       return authorRepository.save(author);
    }
}
