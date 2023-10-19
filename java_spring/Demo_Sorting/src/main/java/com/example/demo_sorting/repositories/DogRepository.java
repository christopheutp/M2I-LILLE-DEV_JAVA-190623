package com.example.demo_sorting.repositories;

import com.example.demo_sorting.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DogRepository extends JpaRepository<Dog, UUID> {
}
