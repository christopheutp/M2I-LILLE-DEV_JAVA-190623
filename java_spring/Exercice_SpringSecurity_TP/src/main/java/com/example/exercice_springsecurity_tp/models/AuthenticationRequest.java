package com.example.exercice_springsecurity_tp.models;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class AuthenticationRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Optional<String> firstname;
    private Optional<String> lastname;

}
