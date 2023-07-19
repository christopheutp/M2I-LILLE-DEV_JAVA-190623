package exercices.variables;

import java.util.Scanner;

public class Exercice7 {
    public static void main(String[] args) {
        /* slide 

         */
        int longueur;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir le coté du carré : ");
        longueur = scanner.nextInt();

        System.out.println("Le périmètre du carré est de : "+ (longueur*4));
        System.out.println("L'ai du carré est de : "+ (longueur*longueur));
    }
}
