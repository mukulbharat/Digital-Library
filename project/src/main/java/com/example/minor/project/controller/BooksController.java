package com.example.minor.project.controller;

import com.example.minor.project.models.entity.Books;
import com.example.minor.project.models.request.CreateBookRequest;
import com.example.minor.project.service.BookService;
import com.example.minor.project.service.CatalogueService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@Slf4j
public class BooksController {

  @Autowired
  CatalogueService catalogueService;

  @Autowired
  BookService bookService;


  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Books> addBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
    return new ResponseEntity<>(catalogueService.addBookToCatalogue(createBookRequest), HttpStatus.CREATED);
  }

  @GetMapping(value = "/book/isbn/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Books> getBooks(@PathVariable("id") String isbn) {
    return new ResponseEntity<>(catalogueService.getBookByIsbn(isbn), HttpStatus.CREATED);
  }

  @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Page<Books>> getBooksByName(@PathVariable("name") String name, @RequestParam(required = false)
                                                    int pageNumber) {
    return new ResponseEntity<>(bookService.getBooksByNameStartingWith(name, pageNumber), HttpStatus.CREATED);
  }
}
