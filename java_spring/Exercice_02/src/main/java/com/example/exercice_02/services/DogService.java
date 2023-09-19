package com.example.exercice_02.services;

import com.example.exercice_02.enums.DogBreed;
import com.example.exercice_02.models.DogDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class DogService {
    private final Map<UUID, DogDTO> dogs;

    public DogService() {
        this.dogs = new HashMap<>();

        DogDTO dogA = DogDTO
                .builder()
                .id(UUID.randomUUID())
                .name("Bernie")
                .breed(DogBreed.LABRADOR)
                .age(4)
                .build();

        DogDTO dogB = DogDTO
                .builder()
                .id(UUID.randomUUID())
                .name("Rex")
                .breed(DogBreed.DOBERMAN)
                .age(7)
                .build();

        DogDTO dogC = DogDTO
                .builder()
                .id(UUID.randomUUID())
                .name("Caramel")
                .breed(DogBreed.BEAGLE)
                .age(12)
                .build();

        dogs.put(dogA.getId(), dogA);
        dogs.put(dogB.getId(), dogB);
        dogs.put(dogC.getId(), dogC);
    }

    public List<DogDTO> getDogs() {
        return dogs.values().stream().toList();
    }

    public Optional<DogDTO> getDogById(UUID id) {
        return dogs.values().stream().filter(d -> d.getId().equals(id)).findFirst();
    }
}
