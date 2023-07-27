package exercices.boucles;

import java.util.Scanner;

public class Exercice9 {
    public static void main(String[] args) {
        // exercice slide 86
        Scanner scanner = new Scanner(System.in);
        StringBuilder decomposition = new StringBuilder();

        System.out.print("\nVeuillez entrer un nombre positif : ");
        int nombre = scanner.nextInt();
        int result = 1;
        decomposition.append("1");

        for (int i = 2; i < nombre + 1; i++) {
            result *= i;
            decomposition.append(" x " + i);
        }

        System.out.printf("%d! = %s = %d", nombre, decomposition, result);
    }
}
