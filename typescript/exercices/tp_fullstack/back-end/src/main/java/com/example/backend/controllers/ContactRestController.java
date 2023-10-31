package com.example.backend.controllers;

import com.example.backend.models.ContactDTO;
import com.example.backend.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/contacts")
@CrossOrigin(origins = {
        "http://localhost:5500",
        "http://127.0.0.1:5500"
})
public class ContactRestController {
    private final ContactService contactService;

    @PostMapping
    public ContactDTO addContact(@RequestBody ContactDTO newContact) {
        return contactService.addContact(newContact);
    }

    @GetMapping
    public Set<ContactDTO> getAllContact() {
        return contactService.getAllContacts();
    }

    @GetMapping("{contactId}")
    public ContactDTO getContactById(@PathVariable UUID contactId) {
        return contactService.getContactById(contactId);
    }

    @PatchMapping("{contactId}")
    public ContactDTO editContactById(@PathVariable UUID contactId, @RequestBody ContactDTO newDetails) {
        return contactService.editContact(contactId, newDetails);
    }

    @DeleteMapping("{contactId}")
    public String deleteContactById(@PathVariable UUID contactId) {
        if (contactService.deleteContactById(contactId)) {
            return "Contact successfuly deleted!";
        } else {
            return "Can't delete this contact!";
        }
    }
}
