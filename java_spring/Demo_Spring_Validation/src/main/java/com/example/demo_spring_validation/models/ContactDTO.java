package com.example.demo_spring_validation.models;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
    private Long id;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @Min(0)
    @Max(200)
    private Integer age;

    @NotNull
    @Email(message = "Pas un bon email!")
    private String email;

    @Null
    private String phoneNumber;
}
