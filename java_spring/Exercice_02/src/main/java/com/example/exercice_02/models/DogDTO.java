package com.example.exercice_02.models;

import com.example.exercice_02.enums.DogBreed;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DogDTO {
    private UUID id;
    private String name;
    private DogBreed breed;
    private Integer age;
}
