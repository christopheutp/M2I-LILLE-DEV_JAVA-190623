package com.example.demo_spring_validation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found!")
public class ResourceNotFound extends RuntimeException{
}
