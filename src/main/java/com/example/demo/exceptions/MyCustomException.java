package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class MyCustomException extends RuntimeException {
    public MyCustomException(String message) {
        super(message);
    }
}
