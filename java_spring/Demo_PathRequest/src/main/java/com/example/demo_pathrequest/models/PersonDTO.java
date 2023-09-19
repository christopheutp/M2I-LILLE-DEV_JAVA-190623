package com.example.demo_pathrequest.models;

import lombok.*;

import java.util.UUID;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
@Data
@Builder
public class PersonDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
}
