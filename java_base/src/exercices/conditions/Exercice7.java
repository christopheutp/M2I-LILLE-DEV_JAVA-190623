package exercices.conditions;

import java.util.Scanner;

public class Exercice7 {
    public static void main(String[] args) {
        // exercice slide 74
        int annee;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.printf("Saisir une année : ");
        annee = scanner.nextInt();

        if ((annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0) {
            System.out.printf("\nL'année %d est bissextile", annee);
        } else {
            System.out.printf("\nL'année %d n'est pas bissextile", annee);
        }
    }
}
