package com.example.exercice_springsecurity_tp.mappers;

import com.example.exercice_springsecurity_tp.entities.Dog;
import com.example.exercice_springsecurity_tp.entities.DogBreed;
import com.example.exercice_springsecurity_tp.models.DogDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DogMapper {
    public Dog dogDtoToDog(DogDTO dto) {
        Dog newDog = new Dog();
        newDog.setId(dto.getId().orElse(null));
        newDog.setName(dto.getName());
        newDog.setBirthDate(dto.getBirthDate());
        newDog.setBreed(Enum.valueOf(DogBreed.class, dto.getBreed().toUpperCase()));
        return newDog;
    }

    public DogDTO dogToDogDTO(Dog dog) {
        return DogDTO.builder()
                .id(Optional.of(dog.getId()))
                .name(dog.getName())
                .birthDate(dog.getBirthDate())
                .breed(dog.getBreed().toString().substring(0, 1).toUpperCase() + dog.getBreed().toString().substring(1).toLowerCase())
                .build();
    }
}
