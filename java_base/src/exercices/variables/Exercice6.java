package exercices.variables;

import java.util.Scanner;

public class Exercice6 {
    public static void main(String[] args) {
        /* slide 

         */
        String chaineInitiale,chaineMinuscule,chaineMajuscule;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir du texte : ");
        chaineInitiale = scanner.nextLine();

        chaineMinuscule = chaineInitiale.toLowerCase();
        chaineMajuscule = chaineInitiale.toUpperCase();
        System.out.println(chaineMinuscule);
        System.out.println(chaineMajuscule);

        // Bonus
        String chainVirgule = String.join(" ,", chaineMinuscule.split(""));
        System.out.println(chainVirgule);

        String[] motsChaine = chaineMinuscule.split(" ");
        String chaineCapitale = "";

        for(String mot : motsChaine){
            chaineCapitale = chaineCapitale + mot.substring(0,1).toUpperCase() + mot.substring(1)+ " ";
        }

        System.out.println(chaineCapitale);
    }
}
