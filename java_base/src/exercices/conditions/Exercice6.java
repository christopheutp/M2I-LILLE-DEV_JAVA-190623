package exercices.conditions;

import java.util.Scanner;

public class Exercice6 {
    public static void main(String[] args) {
        // exercice slide 73
        int mois;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.println("Saisir un n° de mois : ");
        mois = scanner.nextInt();

        switch (mois) {
            case 2 -> System.out.println("28 ou 29 jours");
            case 1,3,5,7,8,10,12 -> System.out.println("31 jours");
            case 4,6,9,11 -> System.out.println("30 jours");
            default -> System.out.println("Mois saisi incorrecte");

        }

    }
}
