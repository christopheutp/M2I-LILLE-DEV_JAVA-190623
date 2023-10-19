package com.example.demo_sorting.mappers;

import com.example.demo_sorting.entities.Dog;
import com.example.demo_sorting.models.DogDTO;
import org.springframework.stereotype.Component;

public class DogMapper {
    public static Dog dtoToDog(DogDTO dto) {
        return Dog
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .breed(dto.getBreed())
                .birthDate(dto.getBirthDate())
                .build();
    }

    public static DogDTO dogtoDto(Dog dog) {
        return DogDTO
                .builder()
                .id(dog.getId())
                .name(dog.getName())
                .breed(dog.getBreed())
                .birthDate(dog.getBirthDate())
                .build();
    }
}
