package com.example.demo_mapping.mappers;

import com.example.demo_mapping.entities.Person;
import com.example.demo_mapping.models.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonMapper {

    @Mapping(source = "firstName", target = "blabla")
    PersonDTO personToPersonDto(Person person);

    @Mapping(source = "blabla", target = "firstName")
    Person personDtoToPerson(PersonDTO dto);
}
