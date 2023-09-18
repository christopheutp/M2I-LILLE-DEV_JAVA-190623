package com.example.demo_bases_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BaseController {
    @RequestMapping(value = "/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/home/person")
    public String personName(Model model) {
        model.addAttribute("firstName", "John");
        model.addAttribute("lastName", "DUPONT");

        List<String> persons = List.of("John DUPONT", "Maria DUPONT", "Chloée SMITH");

        model.addAttribute("persons", persons);

        return "person/details";
    }
}
