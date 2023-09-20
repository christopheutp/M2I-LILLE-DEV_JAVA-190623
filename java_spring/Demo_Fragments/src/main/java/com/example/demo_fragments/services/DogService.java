package com.example.demo_fragments.services;

import com.example.demo_fragments.models.DogDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class DogService {
    private final Map<UUID, DogDTO> dogs;

    public DogService() {
        this.dogs = new HashMap<>();

        DogDTO dogA = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Bernie")
                .breed("Labrador")
                .age(4)
                .build();

        DogDTO dogB = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Caramel")
                .breed("Beagle")
                .age(12)
                .build();

        DogDTO dogC = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Rex")
                .breed("Doberman")
                .age(7)
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

    public DogDTO addDog(DogDTO dogData) {
        if (dogData.getId() == null) {
            dogData.setId(UUID.randomUUID());
        }

        dogs.put(dogData.getId(), dogData);

        return dogData;
    }
}
