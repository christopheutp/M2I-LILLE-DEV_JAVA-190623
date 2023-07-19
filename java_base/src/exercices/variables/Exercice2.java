package exercices.variables;

import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        /* slide 

         */

        int a;
        int b;
        int tmp;

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("Saisir a : ");
        a = scanner.nextInt();
        System.out.println("Saisir b : ");
        b = scanner.nextInt();

        System.out.println("a = "+a+" b = "+b);

        tmp = a;
        a = b;
        b = tmp;

        System.out.println("a = "+a+" b = "+b);
    }
}
