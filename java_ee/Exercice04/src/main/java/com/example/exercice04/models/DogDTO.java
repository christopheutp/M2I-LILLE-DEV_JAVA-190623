package com.example.exercice04.models;

import java.time.LocalDate;

public class DogDTO {

    private Long id;
    private String name;
    private String breed;
    private String birthDate;
    private String isSterilized;

    public DogDTO() {
    }

    public DogDTO(Long id, String name, String breed, String birthDate, String isSterilized) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
        this.isSterilized = isSterilized;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSterilized() {
        return isSterilized;
    }

    public void setSterilized(String sterilized) {
        isSterilized = sterilized;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", birthDate=" + birthDate +
                ", isSterilized=" + isSterilized +
                '}';
    }
}
