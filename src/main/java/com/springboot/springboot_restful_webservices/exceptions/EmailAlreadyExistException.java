package com.springboot.springboot_restful_webservices.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends RuntimeException {

    private String message;
    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
