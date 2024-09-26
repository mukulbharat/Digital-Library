package com.example.minor.project.repository;

import com.example.minor.project.models.entity.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Books, String> {
    Optional<Books> findByisbn(String isbn);

    Page<Books> findAllByNameStartingWith(PageRequest pageRequest, String stringBooksNameStartsWith);
}
