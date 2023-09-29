package com.example.exercice_springsecurity_tp.controllers;

import com.example.exercice_springsecurity_tp.entities.DogBreed;
import com.example.exercice_springsecurity_tp.models.DogDTO;
import com.example.exercice_springsecurity_tp.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dogs")
public class DogController {
    private final DogService dogService;

    @GetMapping
    public String dogList(Model model) {
        model.addAttribute("dogs", dogService.getAllDogs());

        return "dogs/list";
    }

    @GetMapping("details/{dogId}")
    public String getDogDetails(@PathVariable UUID dogId, Model model) {
        model.addAttribute("dog", dogService.getDogById(dogId));
        model.addAttribute("mode", "details");

        return "dogs/dogForm";
    }

    @GetMapping("add")
    public String getAddDogForm(Model model) {
        model.addAttribute("dog", DogDTO.builder().build());
        model.addAttribute("mode", "add");
        model.addAttribute("breeds", DogBreed.values());

        return "dogs/dogForm";
    }

    @PostMapping("add")
    public String addDogHandler0(DogDTO formValues, BindingResult result) {
        if (result.hasErrors()) {
            return "dogs/dogForm";
        }

        dogService.addDog(formValues);

        return "redirect:/dogs";
    }

    @GetMapping("edit/{dogId}")
    public String getEditDogForm(Model model, @PathVariable UUID dogId) {
        model.addAttribute("dog", dogService.getDogById(dogId));
        model.addAttribute("mode", "edit");
        model.addAttribute("breeds", DogBreed.values());

        return "dogs/dogForm";
    }

    @PostMapping("edit/{dogId}")
    public String editDogHandler(DogDTO formValues, BindingResult result, @PathVariable UUID dogId) {
        if (result.hasErrors()) {
            return "dogs/dogForm";
        }

        dogService.editDogById(dogId, formValues);

        return "redirect:/dogs";
    }

    @GetMapping("delete/{dogId}")
    public String getDeleteDogForm(Model model, @PathVariable UUID dogId) {
        model.addAttribute("dog", dogService.getDogById(dogId));
        model.addAttribute("mode", "delete");
        model.addAttribute("breeds", DogBreed.values());

        return "dogs/dogForm";
    }

    @PostMapping("delete/{dogId}")
    public String deleteDogHandler(DogDTO formValues, BindingResult result, @PathVariable UUID dogId) {
        if (dogService.deleteById(dogId)) {
            return "redirect:/dogs";
        } else {
            return "dogs/dogForm";
        }

    }
}
