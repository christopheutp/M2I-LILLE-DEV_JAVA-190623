package com.example.exercice_springsecurity_tp.models;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
public class DogDTO {

    private Optional<UUID> id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String breed;
}
