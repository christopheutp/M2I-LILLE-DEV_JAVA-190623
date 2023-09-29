package com.example.exercice_springsecurity_tp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found!")
public class ResourceNotFound extends RuntimeException {

}
