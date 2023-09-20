package com.example.demo_fragments.controllers;

import com.example.demo_fragments.exceptions.ResourceNotFound;
import com.example.demo_fragments.models.DogDTO;
import com.example.demo_fragments.services.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dogs")
@RequiredArgsConstructor
@Slf4j
public class DogRestController {
    private final DogService dogService;

    @GetMapping
    public List<DogDTO> listDogs(@RequestParam(value = "name", defaultValue = "") String filterByName){
        List<DogDTO> dogs = dogService.getDogs();

        log.debug("GET to /dogs/list");

        if (!filterByName.isEmpty() && !filterByName.isBlank()) {
            dogs = dogs.stream().filter(d -> d.getName().startsWith(filterByName)).toList();
        }

        return dogs;
    }

    @GetMapping("/{dogId}")
    public DogDTO getDetails (@PathVariable("dogId") UUID id){
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {
            return foundDog.get();
        }

        throw new ResourceNotFound();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDogHandler(@RequestBody DogDTO newDog) {
        DogDTO createdDog = dogService.addDog(newDog);

        return new ResponseEntity<String>("Dog created! New id: " + createdDog.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{dogId}")
    public ResponseEntity<String> deleteDogHandler(@PathVariable("dogId") UUID id) {
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {

            if(dogService.deleteDogById(id)) {
                return new ResponseEntity<String>("Dog deleted at id: " + id, HttpStatus.OK);
            }

            return new ResponseEntity<String>("Something went wrong...", HttpStatus.NOT_MODIFIED);

        } else {
            throw new ResourceNotFound();
        }
    }

    @PatchMapping("/{dogId}")
    public DogDTO editDog(@PathVariable("dogId") UUID id, @RequestBody DogDTO dogData) {
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {
            return dogService.editDog(id, dogData);
        } else {
            throw new ResourceNotFound();
        }
    }
}
