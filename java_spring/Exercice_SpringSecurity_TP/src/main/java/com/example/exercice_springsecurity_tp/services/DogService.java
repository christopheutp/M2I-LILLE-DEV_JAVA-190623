package com.example.exercice_springsecurity_tp.services;

import com.example.exercice_springsecurity_tp.entities.Dog;
import com.example.exercice_springsecurity_tp.entities.DogBreed;
import com.example.exercice_springsecurity_tp.exceptions.ResourceNotFound;
import com.example.exercice_springsecurity_tp.mappers.DogMapper;
import com.example.exercice_springsecurity_tp.models.DogDTO;
import com.example.exercice_springsecurity_tp.repositories.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DogService {
    private final DogRepository dogRepository;
    private final DogMapper dogMapper;

    public DogDTO getDogById(UUID id) {
        return dogMapper.dogToDogDTO(dogRepository.findById(id).orElseThrow(ResourceNotFound::new));
    }

    public List<DogDTO> getAllDogs() {
        return dogRepository.findAll().stream()
                .map(dogMapper::dogToDogDTO)
                .collect(Collectors.toList());
    }

    public DogDTO addDog(DogDTO newDog) {
        return dogMapper.dogToDogDTO(dogRepository.save(dogMapper.dogDtoToDog(newDog)));
    }

    public Boolean deleteById(UUID id) {
        if (dogRepository.existsById(id)) {
            dogRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public DogDTO editDogById(UUID id, DogDTO newInfos) {
        Optional<Dog> foundDog = dogRepository.findById(id);

        if (foundDog.isPresent()) {
            if (newInfos.getName() != null) {
                foundDog.get().setName(newInfos.getName());
            }

            if (newInfos.getBirthDate() != null) {
                foundDog.get().setBirthDate(newInfos.getBirthDate());
            }

            if (newInfos.getBreed() != null) {
                foundDog.get().setBreed(Enum.valueOf(DogBreed.class, newInfos.getBreed().toUpperCase()));
            }

            dogRepository.save(foundDog.get());

            return dogMapper.dogToDogDTO(foundDog.get());
        }

        return null;
    }


}
