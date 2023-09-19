package com.example.demo_pathrequest.controllers;

import com.example.demo_pathrequest.exceptions.ResourceNotFoundException;
import com.example.demo_pathrequest.models.DogDTO;
import com.example.demo_pathrequest.services.DogService;
import com.example.demo_pathrequest.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dogs") // http://localhost:8080/api/v1/dogs
public class DogRestController {
    private final DogService dogService;

    @GetMapping("list") // GET http://localhost:8080/api/v1/dogs/list
    public List<DogDTO> listDogs() {
        return dogService.getDogs();
    }

    @GetMapping("details/{dogId}") // GET http://localhost:8080/api/v1/dogs/details/XXXXX
    public ResponseEntity<DogDTO> getDogById(@PathVariable("dogId") UUID id) {
        DogDTO found = dogService.getDogById(id);

        if (found != null) {
            return ResponseEntity.ok(found);
        } else {
            // return new ResponseEntity<DogDTO>(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException();
        }
    }
}
