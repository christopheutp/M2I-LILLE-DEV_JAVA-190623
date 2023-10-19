package com.example.demo_sorting.models;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class DogDTO {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String breed;

    @NotNull
    private LocalDate birthDate;
}
