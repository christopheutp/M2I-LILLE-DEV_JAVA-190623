package com.example.demo_mapping.services;

import com.example.demo_mapping.entities.Person;
import com.example.demo_mapping.mappers.PersonMapper;
import com.example.demo_mapping.models.PersonDTO;
import com.example.demo_mapping.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDTO> listPersons() {
        return personRepository
                .findAll()
                .stream()
                // .map(p -> personMapper.personToPersonDto((p)))
                .map(personMapper::personToPersonDto)
                .toList();
    }

    public PersonDTO addPerson(PersonDTO dto) {
//        Person person = personMapper.personDtoToPerson(dto);
//        Person savedPerson = personRepository.save(person);
//        PersonDTO savedDto = personMapper.personToPersonDto(savedPerson);
//        return savedDto;

        return personMapper.personToPersonDto(personRepository
                .save(personMapper.personDtoToPerson(dto)));
    }
}
