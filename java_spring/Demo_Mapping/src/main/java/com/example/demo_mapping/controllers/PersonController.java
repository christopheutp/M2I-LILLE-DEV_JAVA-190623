package com.example.demo_mapping.controllers;

import com.example.demo_mapping.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/persons")
@RequiredArgsConstructor
@Controller
public class PersonController {
    private final PersonService personService;
    @GetMapping
    public String ListPersons(Model model) {
        model.addAttribute("persons", personService.listPersons());

        return "persons/list";
    }
}
