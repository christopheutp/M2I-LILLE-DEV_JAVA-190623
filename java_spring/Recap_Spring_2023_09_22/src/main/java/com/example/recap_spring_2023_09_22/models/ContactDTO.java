package com.example.recap_spring_2023_09_22.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ContactDTO {
    private UUID id;
    private String firstname;
    private String lastname;
}
