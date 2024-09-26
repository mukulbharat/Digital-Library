package com.example.minor.project.models.request;

import com.example.minor.project.models.entity.Author;
import com.example.minor.project.models.entity.Books;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookRequest {

    @NotBlank(message = "Name of the book should not be null")
    String name;
    @NotBlank(message = "isbn should not be null")
    String isbn;
    @NotNull
    String authorName;
    @NotNull
    String authorEmail;

    public Books toBook(){

        var associatedAuthor= Author.builder()
                .name(authorName)
                .emailId(authorEmail).build();



        return Books.builder()
                .name(name)
                .isbn(isbn)
                .associatedAuthor(associatedAuthor).build();
    }

}
