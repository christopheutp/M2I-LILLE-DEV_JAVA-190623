package exercices.conditions;

import java.util.Scanner;

public class Exercice4 {
    public static void main(String[] args) {
        // exercice slide 71
        char caractere;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.println("Saisir un caractère : ");
        caractere = scanner.next().toLowerCase().charAt(0);

        // Permet de vérifier que le caractère est contenu dans l'alphabet
        if (caractere >= 'a' && caractere <= 'z') {
            // Vérification voyelle
            if (caractere == 'a' || caractere == 'e' || caractere == 'i' || caractere == 'o' || caractere == 'u' || caractere == 'y') {
                System.out.printf("Le caractère %c est une voyelle", caractere);
            } else {
                System.out.printf("Le caractère %c est une consonne", caractere);
            }
        } else {
            System.out.println("Le caractère saisi ne fait pas parti de l'alphabet");
        }

        String voyelles = "aeiouy";

        if (caractere >= 'a' && caractere <= 'z') {
            // la méthode contains permet de vérifier l'existence d'une sous chaine dans une chaine
            if (voyelles.contains(Character.toString(caractere))) {
                System.out.println("\nLe caractère est une voyelle");
            } else {
                System.out.println("\nLe caractère est une consonne");
            }
         } else {
            System.out.println("Le caractère saisi ne fait pas parti de l'alphabet");
        }
    }
}
