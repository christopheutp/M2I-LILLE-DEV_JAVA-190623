package com.example.exercice_02.controllers;

import com.example.exercice_02.exceptions.BlablaPasTrouve;
import com.example.exercice_02.models.DogDTO;
import com.example.exercice_02.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/dogs")
@RequiredArgsConstructor
public class DogController {
    private final DogService dogService;

    @GetMapping("list")
    public String listDogs(Model model) {
        model.addAttribute("dogs", dogService.getDogs());

        return "dogs/list";
    }

    @GetMapping("details/{dogId}")
    public String getDogDetails(@PathVariable UUID dogId, Model model) {
        Optional<DogDTO> foundDog = dogService.getDogById(dogId);

        if (foundDog.isPresent()) {
            model.addAttribute("dog", foundDog.get());
            model.addAttribute("mode", "details");
            return "dogs/details";
        } else {
            throw new BlablaPasTrouve();
        }
    }
}
