package com.example.exercicepokeapi.services;

import com.example.exercicepokeapi.models.PokeAPIResponse;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PokemonService {
    private final RestTemplateBuilder restTemplateBuilder;

    public PokeAPIResponse getPokemonDetails(String value) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<PokeAPIResponse> response = restTemplate.getForEntity("/pokemon/" + value, PokeAPIResponse.class);
        String formattedId = String.format("%03d", response.getBody().getId());
        response.getBody().setId(Integer.parseInt(formattedId));
        return response.getBody();
    }
}
