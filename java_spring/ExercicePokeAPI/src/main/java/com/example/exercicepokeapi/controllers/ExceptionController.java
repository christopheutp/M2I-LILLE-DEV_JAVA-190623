package com.example.exercicepokeapi.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RestClientException.class)
    public String handleRestClientException() {
        return "error/404";
    }
}
