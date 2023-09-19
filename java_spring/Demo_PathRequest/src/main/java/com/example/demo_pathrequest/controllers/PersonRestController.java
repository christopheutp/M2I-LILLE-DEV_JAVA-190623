package com.example.demo_pathrequest.controllers;

import com.example.demo_pathrequest.models.PersonDTO;
import com.example.demo_pathrequest.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/persons")
@RestController
@RequiredArgsConstructor
public class PersonRestController {
    private final PersonService personService;

    @GetMapping("list")
    public List<PersonDTO> listPersons() {
        return personService.getPersons();
    }
}
