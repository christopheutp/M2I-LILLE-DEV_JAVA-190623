package com.example.demo_mapping.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private UUID id;
    private String blabla;
    private String lastName;
    private Integer age;
}
