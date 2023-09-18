package com.example.tp_wconnection_01.models;

import java.time.LocalDate;

public class Dog {
    private static Long idCounter = 0L;

    private final Long id;
    private String name;
    private String breed;
    private LocalDate dateOfBirth;

    public Dog() {
        this.id = ++idCounter;
    }

    public Dog(String name, String breed, LocalDate dateOfBirth) {
        this.id = ++idCounter;
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
