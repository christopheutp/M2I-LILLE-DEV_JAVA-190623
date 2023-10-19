package com.example.demo_sorting.controllers;

import com.example.demo_sorting.models.DogDTO;
import com.example.demo_sorting.services.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dogs")
@RequiredArgsConstructor
@Slf4j
public class DogController {
    private final DogService dogService;
    @GetMapping // http://localhost:8080/dogs?page&sorting
    public ResponseEntity<List<DogDTO>> getDogs(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber, @RequestParam(value = "sorting",  defaultValue = "id") String sortingAttribute) {
        List<DogDTO> dogs = dogService.getAllDogs(pageNumber, 100, sortingAttribute);

        if (dogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(dogs);
        }
    }

    @PostMapping // http://localhost:8080/dogs
    public ResponseEntity<String> addDog(@RequestBody DogDTO newDog) {
        DogDTO addedDog = dogService.addDog(newDog)
                .orElseThrow(() -> new RuntimeException("Something went wrong when adding the dog..."));

        return new ResponseEntity<>("Dog created, id: " + addedDog.getId(), HttpStatus.CREATED);
    }
}
