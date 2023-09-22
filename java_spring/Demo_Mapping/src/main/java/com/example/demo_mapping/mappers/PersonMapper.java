package com.example.demo_mapping.mappers;

import com.example.demo_mapping.entities.Person;
import com.example.demo_mapping.models.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper
public interface PersonMapper {

    @Mapping(source = "firstName", target = "blabla")
    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    PersonDTO personToPersonDto(Person person);

    @Mapping(source = "blabla", target = "firstName")
    Person personDtoToPerson(PersonDTO dto);

    @Named("convertDateToAge")
    public static Integer convertDateToAge(LocalDate date) {
        LocalDate now = LocalDate.now();

        Integer age = now.getYear() - date.getYear();

        if (now.minusYears(age).isBefore(date)) {
            age--;
        }
S
        return age;
    }
}
