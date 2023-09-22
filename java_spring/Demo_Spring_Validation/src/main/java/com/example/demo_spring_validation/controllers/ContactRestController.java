package com.example.demo_spring_validation.controllers;

import com.example.demo_spring_validation.entities.Contact;
import com.example.demo_spring_validation.models.ContactDTO;
import com.example.demo_spring_validation.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactRestController {
    private final ContactService contactService;

    @GetMapping("/{contactId}")
    public Contact getById(@PathVariable("contactId") Long id) {
        System.out.println(id);

        return contactService.getContactById(id);
    }

    @PostMapping
    public ResponseEntity<String> postContact(@RequestBody @Valid ContactDTO newDto, BindingResult results) {
        if(results.hasErrors()){
            StringBuilder errors = new StringBuilder();
            results.getAllErrors().forEach(err -> errors.append(err.toString() + ", "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Contact created", HttpStatus.CREATED);
    }
}
