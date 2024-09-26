package com.example.minor.project.service;

import com.example.minor.project.models.entity.Author;
import com.example.minor.project.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author saveOrUpdate(Author author){
        return authorRepository.save(author);
    }

    public Optional<Author> getAuthorByEmailId(String emailId){
        return authorRepository.findByEmailId(emailId);
    }
}
