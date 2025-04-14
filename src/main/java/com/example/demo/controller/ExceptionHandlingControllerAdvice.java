package com.example.demo.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public String handleException1(EntityNotFoundException ex) {
        return "Error: " + ex.getMessage();
    }

//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ExceptionHandler
//    public ResponseEntity<String> handleException2(Exception ex) {
//        return ResponseEntity
//                .status(HttpStatus.CONFLICT)
//                .body("General Error: " + ex.getMessage());
//    }
}
