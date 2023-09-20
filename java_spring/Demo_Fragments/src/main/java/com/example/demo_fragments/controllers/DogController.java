package com.example.demo_fragments.controllers;

import com.example.demo_fragments.exceptions.ResourceNotFound;
import com.example.demo_fragments.models.DogDTO;
import com.example.demo_fragments.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/dogs")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;

    @GetMapping
    public String listDogs(Model model) {
        model.addAttribute("dogs", dogService.getDogs());

        return "dogs/list";
    }

    @GetMapping("/{dogId}")
    public String getDogDetails(@PathVariable("dogId") UUID id, Model model) {
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {
            model.addAttribute("dog", foundDog.get());
            model.addAttribute("mode", "details");

            return "dogs/dogForm";
        }

        throw new ResourceNotFound();
    }

    @GetMapping("/add")
    public String getDogForm(Model model) {
        model.addAttribute("dog", DogDTO.builder().build());
        model.addAttribute("mode", "add");

        return "dogs/dogForm";
    }

    @PostMapping("/add")
    public String addDogHandler(DogDTO newDog) {
        dogService.addDog(newDog);

        return "redirect:/dogs";
    }
}
