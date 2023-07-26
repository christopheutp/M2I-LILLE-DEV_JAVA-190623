package org.example;

import org.example.heritage.Animal;
import org.example.heritage.Chat;
import org.example.heritage.Chien;

public class AppAnimalerie {
    public static void main(String[] args) {
        Animal animal = new Animal("toto",10,"Bleue");
        animal.crier();

       // System.out.println(animal.anneeNaissance()); // méthode protected

        Chat chat = new Chat("Garfield",5,"Roux");
        chat.crier();

        Chien chien = new Chien("Rex",10, "Roux et bleue",1.20);
        chien.crier();

        chat.manger();

        chien.manger();

        System.out.println(animal);
        System.out.println(chien);
        System.out.println(chat);
        System.out.println();

        // Objet est l'objet racine dont toutes les classes héritent
        Object object = new Object();




    }
}
