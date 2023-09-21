package com.example.demo_mapping.repositories;

import com.example.demo_mapping.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    List<Person> findAllByFirstNameStartingWith (String value);
    Long countAllByFirstNameStartingWith(String value);
}
