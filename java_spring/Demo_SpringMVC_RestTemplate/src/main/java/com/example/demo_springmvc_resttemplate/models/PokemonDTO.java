package com.example.demo_springmvc_resttemplate.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PokemonDTO {
    private List<String> abilities = new ArrayList<>();
}
