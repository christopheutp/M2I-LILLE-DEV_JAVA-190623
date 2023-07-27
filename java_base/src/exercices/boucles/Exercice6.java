package exercices.boucles;

import java.util.Scanner;

public class Exercice6 {
    public static void main(String[] args) {
        // exercice slide 83
        int nbNote;
        double min = 0;
        double max = 0;
        double somme = 0;
        Scanner scanner;

        scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre de notes : ");
        nbNote = scanner.nextInt();

        // Verification du nombre de notes (toujours positif)
        while (nbNote < 1) {
            System.out.println("Saisie incorrecte : ");
            nbNote = scanner.nextInt();
        }

        for (int cptNote = 1; cptNote < nbNote + 1; cptNote++) {

            System.out.printf("\rnote %d : ", cptNote);
            double note = scanner.nextDouble();

            // Vérification de la note entre 0 et 20
            while (note < 0 || note > 20) {
                System.out.println("Saisie incorrecte : ");
                note = scanner.nextDouble();
            }

            // Si une seule note, alors à la fois max, min et moyenne
            if (cptNote == 1) {
                min = note;
                max = note;
            }

            if (note > max) {
                max = note;
            }


            if (note < min) {
                min = note;
            }

            somme += note;

        }

        System.out.println("La note max est : " + max);
        System.out.println("La note min est : " + min);
        System.out.println("La moyenne est de : " + (somme / nbNote));
    }
}
