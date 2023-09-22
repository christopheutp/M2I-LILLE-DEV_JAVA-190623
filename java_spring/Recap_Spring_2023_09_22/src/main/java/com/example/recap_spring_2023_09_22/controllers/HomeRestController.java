package com.example.recap_spring_2023_09_22.controllers;

import com.example.recap_spring_2023_09_22.models.ContactDTO;
import com.example.recap_spring_2023_09_22.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/home")
@RequiredArgsConstructor
public class HomeRestController {

    private final ContactService contactService;
    @GetMapping("/{contactId")
    public ContactDTO findContact(@PathVariable UUID contactId, BindingResult result) {
        if (result.hasErrors()) {
            // Retourner les messages d'erreurs
        }

        ContactDTO foundContact = contactService.getById(contactId);

        return foundContact;

    }
}
