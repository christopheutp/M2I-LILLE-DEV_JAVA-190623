package com.example.demo_bases_spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/home")
public class BaseRestController {
    @GetMapping
    public String getPersonFullName() {
        return "John DUPONT";
    }

    @GetMapping(value = "persons")
    public List<String> getPersonsFullNames() {
        return List.of("John DUPONT", "Maria MARTEZ", "Chloée SMITH");
    }
}
