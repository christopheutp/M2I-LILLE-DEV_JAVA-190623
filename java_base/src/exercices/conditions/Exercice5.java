package exercices.conditions;

import java.util.Scanner;

public class Exercice5 {
    public static void main(String[] args) {
        // exercice slide 72
        int jour;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.println("Saisir un jour de la semaine : ");
        jour = scanner.nextInt();

        switch (jour) {
            case 1 -> System.out.println("Lundi");
            case 2 -> System.out.println("Mardi");
            case 3 -> System.out.println("Mercredi");
            case 4 -> System.out.println("Jeudi");
            case 5 -> System.out.println("Vendredi");
            case 6 -> System.out.println("Samedi");
            case 7 -> System.out.println("Dimanche");
            default -> System.out.println("Saisie invalide");
        }
    }
}
