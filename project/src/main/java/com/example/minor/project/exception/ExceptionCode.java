package com.example.minor.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
//@Setter
@ToString
@AllArgsConstructor
public enum ExceptionCode {
        BOOK_NOT_FOUND("LM_BOOK_001","BOOK NOT FOUND", HttpStatus.NOT_FOUND),
        BOOK_ALREADY_EXISTS("LM_BOOK_002", "Book Already Exists", HttpStatus.BAD_REQUEST),
        BOOK_ALREADY_ISSUED("LM_BOOK_003", "Book Already Issued", HttpStatus.BAD_REQUEST),
        BOOK_QUOTA_EXHAUSTED("LM_BOOK_004", "Book Quota Exhausted", HttpStatus.BAD_REQUEST),
        USER_ALREADY_EXISTS("LM_USER_001", "User Already Exists", HttpStatus.BAD_REQUEST),
        USER_NOT_FOUND("LM_USER_002", "User Not Found", HttpStatus.BAD_REQUEST),
        INVALID_USER("LM_USER_003", "User Is Invalid", HttpStatus.BAD_REQUEST);
        final String errorCode;
        final String errorMessage;
        final HttpStatus status;

}
