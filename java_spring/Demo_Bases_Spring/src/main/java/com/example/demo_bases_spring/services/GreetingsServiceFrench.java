package com.example.demo_bases_spring.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("salutations")

// Si l'on veut, on peut définir par défault quelle implémentation va être utilisée par Spring pour l'injection

// Soit via l'annotation @Primary
// @Primary

// Soit en ajoutant en profil "default"
@Profile({"FR", "default"})
public class GreetingsServiceFrench implements GreetingsService {
    @Override
    public String sayHello() {
        return "Bonjour tout le monde";
    }
}
