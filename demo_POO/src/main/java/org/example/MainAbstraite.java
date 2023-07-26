package org.example;

import org.example.abstraite.Animal;
import org.example.abstraite.Chat;
import org.example.abstraite.Chien;

public class MainAbstraite {
    public static void main(String[] args) {
     //   Animal animal = new Animal(); // Imposssible d'instancier une classe abstraite
        Chat chat = new Chat("félix",3,"noir et blanc");
        chat.crier();
        chat.manger();

        Chien chien = new Chien("Bill",10,"Roux");
        chien.crier();
        chien.manger();
    }
}
