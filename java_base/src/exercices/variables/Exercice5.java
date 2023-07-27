package exercices.variables;

import java.util.Scanner;

public class Exercice5 {
    public static void main(String[] args) {
        /* slide 55

         */
        double rayon,hauteur,volume;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.println("Saisir un rayon : ");
        rayon = scanner.nextDouble();
        System.out.println("Saisir une hauteur : ");
        hauteur = scanner.nextDouble();

        volume = 1./3. * Math.PI * (rayon * rayon) * hauteur;
        // System.out.println(1./3.);

        System.out.println(volume);

        // Floor arrondi à l'entier le plus proche vers le bas
        System.out.println(Math.floor(volume));
        // Ceil arrondi à l'entier le plus proche vers le haut
        System.out.println(Math.ceil(volume));

        // Arrondi 2 chiffres apres la virgule
        volume = Math.round(volume * 100.) / 100.;
        System.out.println(volume);
    }
}
