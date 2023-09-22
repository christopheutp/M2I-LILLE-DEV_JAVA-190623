package com.example.recap_spring_2023_09_22.repositories;

import com.example.recap_spring_2023_09_22.models.ContactDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<ContactDTO, UUID> {
    ContactDTO getContactDTOByLastnameStartingWith(String searchInput);
}
