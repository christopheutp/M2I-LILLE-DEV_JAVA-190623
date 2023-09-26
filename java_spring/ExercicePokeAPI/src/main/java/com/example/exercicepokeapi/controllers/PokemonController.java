package com.example.exercicepokeapi.controllers;

import com.example.exercicepokeapi.models.PokeAPIResponse;
import com.example.exercicepokeapi.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;
    @GetMapping("/{idOrName}")
    public String getPokemonDetails(@PathVariable("idOrName") String value) {
        String finalValue;

        try {
            Integer valueAsInteger = Integer.parseInt(value);
            finalValue = valueAsInteger.toString();
        } catch (NumberFormatException ex) {
            finalValue = value;
        }

        PokeAPIResponse response = pokemonService.getPokemonDetails(finalValue);

        return "pokemon/details";
    }
}
