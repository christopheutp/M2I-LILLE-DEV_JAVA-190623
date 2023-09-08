package com.example.exercice04.models;

import java.time.LocalDate;

public class Dog {
    private static Long count = 0L;

    private final Long id;
    private String name;
    private String breed;
    private LocalDate birthDate;
    private Boolean isSterilized;

    public Dog() {
        this.id = ++count;
    }

    public Dog(String name, String breed, LocalDate birthDate, Boolean isSterilized) {
        this.id = ++count;
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
        this.isSterilized = isSterilized;
    }

    public Long getId() {
        return id;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getSterilized() {
        return isSterilized;
    }

    public void setSterilized(Boolean sterilized) {
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
