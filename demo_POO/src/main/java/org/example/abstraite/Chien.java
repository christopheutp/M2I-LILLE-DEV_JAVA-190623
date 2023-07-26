package org.example.abstraite;

public class Chien extends Animal{
    public Chien(String nom, int age, String couleur) {
        super(nom, age, couleur);
    }

    @Override
    public void crier() {
        System.out.println("wouf wouf");
    }
}
