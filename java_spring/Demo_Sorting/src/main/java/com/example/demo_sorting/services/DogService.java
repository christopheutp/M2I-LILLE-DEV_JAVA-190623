package com.example.demo_sorting.services;

import com.example.demo_sorting.entities.Dog;
import com.example.demo_sorting.mappers.DogMapper;
import com.example.demo_sorting.models.DogDTO;
import com.example.demo_sorting.repositories.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogService {
    private final DogRepository dogRepository;

    public List<DogDTO> getAllDogs(int nbPage, int pageSize, String sortingAttribute) {
        return dogRepository.findAll(PageRequest.of(nbPage - 1, pageSize, Sort.by(sortingAttribute)))
                .map(DogMapper::dogtoDto)
                .toList();
    }

    public Optional<DogDTO> addDog(DogDTO newDog) {
        try {
            return Optional.of(DogMapper.dogtoDto(dogRepository.save(DogMapper.dtoToDog(newDog))));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
