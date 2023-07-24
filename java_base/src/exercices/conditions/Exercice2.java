package exercices.conditions;

import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        int nombre;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.print("Saisir un nombre : ");
        nombre = scanner.nextInt();

        if (nombre % 2 == 0) {
            System.out.println("le nombre est pair");
        } else {
            System.out.println("le nombre est impair");
        }
    }
}
