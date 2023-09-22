package com.example.demo_spring_validation.controllers;

import com.example.demo_spring_validation.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> dividedByZero(){
        return new ResponseEntity<>("Divided by Zero!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(ResourceNotFound.class)
//    public ResponseEntity<String> resourceNotFound() {
//        return new ResponseEntity<>("Not found!", HttpStatus.NOT_FOUND);
//    }
}
