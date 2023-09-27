package com.example.exospringsecurity01.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PublicController {
    @GetMapping
    public String homePage() {
        return "home";
    }

    @GetMapping("dogs")
    public String listDogs() {
        return "dogs/list";
    }
}
