package com.example.recap_spring_2023_09_22.controllers;

import com.example.recap_spring_2023_09_22.exceptions.ResourceNotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ResourceNotFound.class)
    public String notFound() {
        return "error/404";
    }
}
