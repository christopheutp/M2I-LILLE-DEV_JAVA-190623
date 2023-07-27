package exercices.conditions;

import java.util.Scanner;

public class Exercice8 {
    public static void main(String[] args) {
        // exercice slide 75
        char caractere;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.print("Saisir un caractère : ");
        caractere = scanner.next().charAt(0);

        if(Character.isLetterOrDigit(caractere)){
            if(Character.isLetter(caractere)){
                System.out.printf("\rLe caractère '%c' est une lettre de l'alphabet", caractere);
            }else {
                System.out.printf("\rLe caractère '%c' est un chiffre", caractere);
            }
        }else {
            System.out.printf("\rLe caractère '%c' est un caractère spécial", caractere);
        }
    }
}
