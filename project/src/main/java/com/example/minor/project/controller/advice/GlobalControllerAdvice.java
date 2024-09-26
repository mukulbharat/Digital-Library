package com.example.minor.project.controller.advice;


import com.example.minor.project.exception.EntityExceptions;
import com.example.minor.project.models.response.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {



    @ExceptionHandler(value={EntityExceptions.class})
    public ResponseEntity<ErrorMessage> catchBooksException(EntityExceptions exceptions){
      return new ResponseEntity<>(ErrorMessage.builder()
              .errorCode(exceptions.getExceptionCode()
                      .getErrorCode())
              .errorMessage(exceptions.getExceptionCode().getErrorMessage()).build(),
              exceptions.getExceptionCode().getStatus());
    }

//    @ExceptionHandler(value=UserException.class)
//    public ResponseEntity<ErrorMessage> catchUserInfoException(UserException Exception){
//        return new ResponseEntity<>(ErrorMessage.builder()
//                .errorCode(Exception.getExceptionCode()
//                        .getErrorCode())
//                .errorMessage(Exception.getExceptionCode().getErrorMessage()).build(),
//                Exception.getExceptionCode().getStatus());
    //}

}
