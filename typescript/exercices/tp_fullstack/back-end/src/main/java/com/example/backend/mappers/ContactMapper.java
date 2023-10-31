package com.example.backend.mappers;

import com.example.backend.entities.ContactEntity;
import com.example.backend.models.ContactDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class ContactMapper {
    public ContactEntity toEntity(ContactDTO dto) {
        UUID uuid;

        if (dto.getId() != null) {
            uuid = UUID.fromString(dto.getId());
        } else {
            uuid = UUID.randomUUID();
        }

        return new ContactEntity(
                uuid,
                dto.getFirstname(),
                dto.getLastname(),
                LocalDate.parse(dto.getBirthDate().substring(0, "yyyy-MM-dd".length()), DateTimeFormatter.ISO_DATE),
                dto.getEmail(),
                dto.getPhoneNumber()
        );
    }

    public ContactDTO toDTO(ContactEntity entity) {
        return ContactDTO
                .builder()
                .id(entity.getId().toString())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .birthDate(entity.getBirthDate().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }
}
