package com.example.demo_bases_spring.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// On peut définir des noms pour nos services pour choisir à la dépendance près quelle implémentation on souhaite.
// Par défault, les services auront comme Qualifier leur nom en camelCase
@Service("greetings")
@Profile("EN")
public class GreetingsServiceEnglish implements GreetingsService {
    @Override
    public String sayHello() {
        return "Hello everyone!";
    }
}
