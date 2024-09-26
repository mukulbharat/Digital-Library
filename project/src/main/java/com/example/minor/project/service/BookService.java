package com.example.minor.project.service;

import com.example.minor.project.exception.BooksException;
import com.example.minor.project.exception.ExceptionCode;
import com.example.minor.project.models.entity.Books;
import com.example.minor.project.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class BookService {

    @Autowired
    BookRepository booksRepository;

    public Books getBookNotIssuedToUser(UUID bookId){
        return booksRepository.findById(bookId.toString())
                .orElseThrow(() -> new BooksException(ExceptionCode.BOOK_NOT_FOUND));
    }

    public Books saveOrUpdate(Books books){
        return booksRepository.save(books);
    }

    public Optional<Books> getBooksByIsbn(String isbn){
        return booksRepository.findByisbn(isbn);
    }
    public Page<Books> getBooksByNameStartingWith(String nameStartsWith,int pageNumber){
        PageRequest pageRequest= PageRequest.of(pageNumber,3, Sort.by(Sort.Direction.DESC, "createdAt"));
       // Pageable pageable=Pageable.ofSize(20);
        return booksRepository.findAllByNameStartingWith(pageRequest, nameStartsWith);
    }
}
