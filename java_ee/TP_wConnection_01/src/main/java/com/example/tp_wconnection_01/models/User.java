package com.example.tp_wconnection_01.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static Long idCounter = 0L;

    private final Long id;
    private String email;
    private String password;

    private List<Dog> dogs;

    public User() {
        this.id = ++idCounter;
        dogs = new ArrayList<>();
    }

    public User(String email, String password) {
        this.id = ++idCounter;
        this.email = email;
        this.password = password;
        dogs = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
