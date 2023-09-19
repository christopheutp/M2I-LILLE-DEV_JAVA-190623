package com.example.exercice_02.controllers;

import com.example.exercice_02.models.DogDTO;
import com.example.exercice_02.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dogs")
public class DogRestController {
    private final DogService dogService;

    @GetMapping("list")
    public List<DogDTO> getDogs() {
        return dogService.getDogs();
    }

    @GetMapping("details/{blabla}")
    public ResponseEntity<DogDTO> getDetails(@PathVariable("blabla") UUID id) {
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {
            return ResponseEntity.ok(foundDog.get());
        } else {
            return new ResponseEntity<DogDTO>(HttpStatus.NOT_FOUND);
        }

    }
}
