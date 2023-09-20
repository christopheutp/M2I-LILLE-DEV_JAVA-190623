package com.example.demo_fragments.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DogDTO {
    private UUID id;
    private String name;
    private String breed;
    private Integer age;
}
