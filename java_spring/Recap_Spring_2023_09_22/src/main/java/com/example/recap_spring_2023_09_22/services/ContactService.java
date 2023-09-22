package com.example.recap_spring_2023_09_22.services;

import com.example.recap_spring_2023_09_22.exceptions.ResourceNotFound;
import com.example.recap_spring_2023_09_22.models.ContactDTO;
import com.example.recap_spring_2023_09_22.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactDTO getById(UUID id) {
        return contactRepository.findById(id).orElseThrow(ResourceNotFound::new);
    }
}
