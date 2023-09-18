package com.example.tp_wconnection_01.models;

import java.time.LocalDate;

public class DogDTO {

    private Long id;
    private String name;
    private String breed;
    private String dateOfBirth;

    public DogDTO() {
        this.id = 0L;
        this.name = "";
        this.breed = "";
        this.dateOfBirth = LocalDate.now().toString();
    }

    public DogDTO(Long id, String name, String breed, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
