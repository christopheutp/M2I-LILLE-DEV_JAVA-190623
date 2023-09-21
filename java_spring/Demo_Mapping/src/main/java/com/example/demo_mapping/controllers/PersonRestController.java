package com.example.demo_mapping.controllers;

import com.example.demo_mapping.entities.Person;
import com.example.demo_mapping.models.PersonDTO;
import com.example.demo_mapping.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonRestController {
    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> listPersons() {
        return personService.listPersons();
    }

    @PostMapping
    public PersonDTO addPerson(@RequestBody PersonDTO dto) {
        return personService.addPerson(dto);
    }
}
