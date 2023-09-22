package com.example.demo_spring_validation.services;

import com.example.demo_spring_validation.entities.Contact;
import com.example.demo_spring_validation.exceptions.ResourceNotFound;
import com.example.demo_spring_validation.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Primary
public class ContactService {
    private final ContactRepository contactRepository;

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElseThrow(ResourceNotFound::new);
    }
}
