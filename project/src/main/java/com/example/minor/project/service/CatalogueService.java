package com.example.minor.project.service;

import com.example.minor.project.exception.BooksException;
import com.example.minor.project.exception.ExceptionCode;
import com.example.minor.project.models.entity.Author;
import com.example.minor.project.models.entity.Books;
import com.example.minor.project.models.request.CreateBookRequest;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service@Slf4j
public class CatalogueService {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Transactional
    public Books addBookToCatalogue(CreateBookRequest createBookRequest){
      var inMemoryBook=createBookRequest.toBook();
      log.info("received request {} mapped to book {}",createBookRequest, inMemoryBook);

      //check if author exists
        var existingAuthor = authorService. getAuthorByEmailId(inMemoryBook.getAssociatedAuthor().getEmailId());
        log.info(" existing author {} ",existingAuthor);
        if(existingAuthor.isEmpty()){
            Author author=authorService.saveOrUpdate(inMemoryBook.getAssociatedAuthor());
            //update the author
            log.info(" author is created {}", author);
            inMemoryBook.setAssociatedAuthor(author);
        } else{
            inMemoryBook.setAssociatedAuthor(existingAuthor.get());
        }
        log.info(" inMemory {}", inMemoryBook);
       //check if book exists
        var existingBook= bookService.getBooksByIsbn(inMemoryBook.getIsbn());
        if(existingBook.isPresent()){
            throw new BooksException(ExceptionCode.BOOK_ALREADY_EXISTS);
        }
        log.info(" existing book {}",existingBook);
        return bookService.saveOrUpdate(inMemoryBook);
    }
    public Books getBookByIsbn(String isbn){
        var existingBook= bookService.getBooksByIsbn(isbn);
        if(existingBook.isEmpty()){
            throw new BooksException(ExceptionCode.BOOK_NOT_FOUND);
        }

        return existingBook.get();
    }
}
