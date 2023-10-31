package com.example.backend.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ContactDTO {
    private String id;
    private String firstname;
    private String lastname;
    private String birthDate;
    private String email;
    private String phoneNumber;
}
