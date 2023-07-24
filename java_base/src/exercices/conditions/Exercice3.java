package exercices.conditions;

import java.util.Scanner;

public class Exercice3 {
    public static void main(String[] args) {
        int nombre1, nombre2, nombre3, max;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.print("Saisir le nombre 1 : ");
        nombre1 = scanner.nextInt();
        System.out.print("\rSaisir le nombre 2 : ");
        nombre2 = scanner.nextInt();
        System.out.print("\rSaisir le nombre 3 : ");
        nombre3 = scanner.nextInt();

        if (nombre1 > nombre2) {
            if (nombre1 > nombre3) {
                max = nombre1;
            } else {
                max = nombre3;
            }
        } else if (nombre2 > nombre3) {
            max = nombre2;
        } else {
            max = nombre3;
        }

        System.out.printf("\rLa valeur maximale parmi ces 3 nombres est %d", max);

        if (nombre1 >= nombre2 && nombre1 >= nombre3) {
            max = nombre1;
        } else if (nombre2 >= nombre1 && nombre2 >= nombre3) {
            max = nombre2;
        } else {
            max = nombre3;
        }

        System.out.println("\n" + max);
    }
}
