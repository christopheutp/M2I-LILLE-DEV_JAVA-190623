package com.example.demo_pathrequest.services;

import com.example.demo_pathrequest.models.DogDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Primary
public class DogService {
    private final Map<UUID, DogDTO> dogs;

    public DogService() {
        dogs = new HashMap<>();

        DogDTO dogA = DogDTO.builder()
                .id(UUID.randomUUID())
                .age(5)
                .name("Bernie")
                .breed("Labrador")
                .build();

        DogDTO dogB = DogDTO.builder()
                .id(UUID.randomUUID())
                .age(3)
                .name("Rex")
                .breed("Doberman")
                .build();

        DogDTO dogC = DogDTO.builder()
                .id(UUID.randomUUID())
                .age(12)
                .name("Caramel")
                .breed("Beagle")
                .build();

        dogs.put(dogA.getId(), dogA);
        dogs.put(dogB.getId(), dogB);
        dogs.put(dogC.getId(), dogC);
    }

    public List<DogDTO> getDogs() {
        return dogs.values().stream().toList();
    }

    public DogDTO getDogById(UUID id) {
        return dogs.values().stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}
