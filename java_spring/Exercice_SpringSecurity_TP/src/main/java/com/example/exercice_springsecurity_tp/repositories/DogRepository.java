package com.example.exercice_springsecurity_tp.repositories;

import com.example.exercice_springsecurity_tp.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DogRepository extends JpaRepository<Dog, UUID> {
    List<Dog> findAllByName(String name);
}
