package com.example.minor.project.exception;


import lombok.Getter;


@Getter

public class UserException extends EntityExceptions{

    public UserException(ExceptionCode exceptionCode){
        super(exceptionCode);
    }

}
