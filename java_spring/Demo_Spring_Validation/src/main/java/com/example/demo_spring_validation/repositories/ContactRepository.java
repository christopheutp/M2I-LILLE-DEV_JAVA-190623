package com.example.demo_spring_validation.repositories;

import com.example.demo_spring_validation.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
