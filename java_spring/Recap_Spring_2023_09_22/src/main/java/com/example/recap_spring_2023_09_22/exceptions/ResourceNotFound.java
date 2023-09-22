package com.example.recap_spring_2023_09_22.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "On a rien trouvé !")
public class ResourceNotFound extends RuntimeException {
}
