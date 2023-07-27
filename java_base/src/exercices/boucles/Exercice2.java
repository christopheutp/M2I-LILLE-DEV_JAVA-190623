package exercices.boucles;

import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        // exercice slide 79
        int chapitre;
        int sousPartie;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.print("Saisir un nombre de chapitres : ");
        chapitre = scanner.nextInt();

        System.out.print("\nSaisir un nombre de sous-parties : ");
        sousPartie = scanner.nextInt();

        // Itère sur les chapitres
        for (int nbChapitre = 1; nbChapitre < chapitre + 1; nbChapitre++) {
            System.out.printf("\nChapitre %d", nbChapitre);
            // Itère sur les sous parties à chaque chapitre
            for (int nbSousChapitre = 1; nbSousChapitre < sousPartie + 1; nbSousChapitre++) {
                System.out.printf("\n\tSous-partie %d.%d", nbChapitre, nbSousChapitre);
            }
        }
    }
}
