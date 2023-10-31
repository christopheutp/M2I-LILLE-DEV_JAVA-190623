package com.example.backend.services;

import com.example.backend.entities.ContactEntity;
import com.example.backend.mappers.ContactMapper;
import com.example.backend.models.ContactDTO;
import com.example.backend.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactDTO addContact(ContactDTO newContact) {
        return contactMapper.toDTO(contactRepository.save(contactMapper.toEntity(newContact)));
    }

    public ContactDTO getContactById(UUID id) {
        return contactMapper.toDTO(contactRepository.getReferenceById(id));
    }

    public Set<ContactDTO> getAllContacts() {
        return contactRepository.findAll().stream().map(contactMapper::toDTO).collect(Collectors.toSet());
    }

    public ContactDTO editContact(UUID id, ContactDTO newDetails) {
        Optional<ContactEntity> foundContact = contactRepository.findById(id);

        if (foundContact.isPresent()) {
            if(newDetails.getFirstname() != null) {
                foundContact.get().setFirstname(newDetails.getFirstname());
            }

            if (newDetails.getLastname() != null) {
                foundContact.get().setLastname(newDetails.getLastname());
            }

            if (newDetails.getEmail() != null) {
                foundContact.get().setEmail(newDetails.getEmail());
            }

            if (newDetails.getPhoneNumber() != null) {
                foundContact.get().setPhoneNumber(newDetails.getPhoneNumber());
            }

            if (newDetails.getBirthDate() != null) {
                foundContact.get().setBirthDate(LocalDate.parse(newDetails.getBirthDate()));
            }

            contactRepository.save(foundContact.get());

            return contactMapper.toDTO(foundContact.get());
        }

        return null;
    }

    public Boolean deleteContactById(UUID id) {
        try {
            contactRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
