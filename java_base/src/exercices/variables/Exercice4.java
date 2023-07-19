package exercices.variables;

import java.util.Scanner;

public class Exercice4 {
    public static void main(String[] args) {
        /* slide 

         */
        int age;
        boolean estMajeur;
        Scanner scanner;

        scanner = new Scanner(System.in);
        System.out.println("Saisir age :");
        age = scanner.nextInt();

        estMajeur = age >= 18;

        System.out.println(estMajeur);

        System.out.println(age >= 18);
    }
}
