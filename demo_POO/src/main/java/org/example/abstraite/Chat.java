package org.example.abstraite;

public class Chat extends Animal{
    public Chat(String nom, int age, String couleur) {
        super(nom, age, couleur);
    }

    @Override
    public void crier() {
        System.out.println("Miaou Miaou");
    }
}
