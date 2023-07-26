package org.example;


import org.example.statique.Maison;

public class Main {
    public static void main(String[] args) {

        System.out.println("Nombre de maisons instanciées : "+ Maison.getNombreMaisons());

        Maison maison = new Maison("Orange",4,12.5,20);
        System.out.println(maison.getCouleur());
        maison.setCouleur("Bleu");
        System.out.println(maison.getCouleur());
        maison.setCouleur("Rouge");
        System.out.println(maison.getCouleur());

        Maison maisonJolie = new Maison("Jaune",1,2,3);

       // System.out.println(Maison.nombreMaisons); // private utilisation du getter
        System.out.println("Nombre de maisons instanciées : "+ Maison.getNombreMaisons());
        System.out.println(Maison.nomLatin);

        // Exemple de méthodes statiques
        Math.round(120.3);

        String.format("%s","toto");

    }
}