package com.example.backend.repositories;

import com.example.backend.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<ContactEntity, UUID> {
}
