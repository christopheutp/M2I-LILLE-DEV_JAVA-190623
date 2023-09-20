package com.example.demo_fragments.controllers;

import com.example.demo_fragments.exceptions.ResourceNotFound;
import com.example.demo_fragments.models.DogDTO;
import com.example.demo_fragments.services.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/dogs")
@RequiredArgsConstructor
@Slf4j
public class DogController {

    private final DogService dogService;

    @GetMapping
    public String listDogs(Model model, @RequestParam(value = "name", defaultValue = "") String filterByName) {
        List<DogDTO> dogs = dogService.getDogs();

        if (!filterByName.isEmpty() && !filterByName.isBlank()) {
            dogs = dogs.stream().filter(d -> d.getName().startsWith(filterByName)).toList();
        }

        model.addAttribute("dogs", dogs);

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
    public String getDogForm(Model model, @RequestParam(value = "exemple", defaultValue = "default") String blabla) {
        log.debug("blabla: " + blabla);

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
