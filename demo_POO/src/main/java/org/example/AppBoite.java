package org.example;

import org.example.generique.Boite;
import org.example.heritage.Chat;

public class AppBoite {
    public static void main(String[] args) {
        // Boite pour une chaine de caractére
        Boite<String> boiteString = new Boite<>("Contenu de la boite");
        String contenuString = boiteString.getContenu();
        System.out.println("Contenu de la boite String :"+contenuString);

        // Boite pour chat
        Boite<Chat> boiteChat = new Boite<>(new Chat("fifi",42,"Bleue"));
        Chat contenuChat = boiteChat.getContenu();
        System.out.println("Contenu de la boite Chat :"+contenuChat);

        // Boite pour un double
        Boite<Double> boiteDouble = new Boite<>(3.14);
        Double contenuDouble = boiteDouble.getContenu();
        System.out.println("Contenu de la boite Double :"+contenuDouble);

    }
}
