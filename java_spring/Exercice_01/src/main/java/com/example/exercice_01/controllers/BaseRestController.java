package com.example.exercice_01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/base") // http://localhost:8080/api/v1/base
public class BaseRestController {
    @GetMapping("1-param")
    public String get1Param() {
        return "John DUPONT";
    }

    @GetMapping("params")
    public List<String> getCollParams() {
        return List.of("John DUPONT", "Maria MARTEZ", "Chloée SMITH");
    }
}
