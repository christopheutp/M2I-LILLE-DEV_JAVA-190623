package exercices.boucles;

import java.util.Scanner;

public class Exercice5 {
    public static void main(String[] args) {
        // exercice slide 82

        int nombre;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.print("Saisir un nombre entier : ");
        nombre = scanner.nextInt();

        // La première boucle gère le début de la suite
        for (int cpt = 1; cpt < nombre / 2 + 1; cpt++) {
            String result = nombre + " = " + cpt;
            int somme = cpt;
            // La seconde boucle permet de caculer le reste de la suite
            for (int suite = cpt + 1; cpt < nombre / 2 + 2; suite++) {
                result += " + " + suite;
                somme += suite;

                // Si on dépasse, on sortie de la boucle
                if (somme > nombre) {
                    break;
                    // Si la somme est égale au nombre, on affiche et on sort de la boucle
                } else if (somme == nombre) {
                    System.out.println(result);
                    break;
                }
                // sinon, on continue d'incrémenter la somme
            }
        }
    }
}
