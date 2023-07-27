package exercices.variables;

import java.util.Scanner;

public class Exercice3 {
    public static void main(String[] args) {
        /* slide 53

         */
        int a,b,sommeCarre;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.println("Saisir a : ");
        a = scanner.nextInt();
        System.out.println("Saisir b : ");
        b = scanner.nextInt();

        sommeCarre = a * a + b * b;

        System.out.println("La somme des carrés de a et b est : "+sommeCarre);
    }
}
