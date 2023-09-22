package com.example.demo_spring_validation.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseRestController {

    @GetMapping
    public String getBaseRoute(){

        Integer nombre = 25 / 0;

        return "Hello World";
    }


}
