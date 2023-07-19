package demos;

import java.util.Scanner;

public class Boucles {
    public static void main(String[] args) {
    // Utilisation de la boucle for lorsque l'on sait d'avance combien de fois on doit itérer

        // for (variable d'itération; condition; pas)
        for (int compteur = 0; compteur < 10; compteur++) {
            System.out.println(compteur * 2);
        }

        for (int compteur2 = 10; compteur2 > 0; compteur2--) {
            System.out.println(compteur2);
        }

        // Boucle qui va de 1 à 10
        for (int compteur3 = 1; compteur3 < 11; compteur3++) {
            // boucle qui va de 1 à 2
            for (int compteur4 = 1; compteur4 < 3; compteur4++) {
                System.out.println("compteur boucle 1 : " + compteur3 + " compteur boucle 2 : " + compteur4);
            }
        }

        // prenom[0] => arthur
        String[] prenoms = {"arthur", "toto", "tata"};

        // Parcours d'un tableau avec sa taille
        for (int cpt = 0; cpt < prenoms.length; cpt++) {
            System.out.printf("prenom[%d] = %s\n", cpt, prenoms[cpt]);
        }

        // for each
        // parcourt chaque élément d'un conteneur
        for (String prenom : prenoms) {
            System.out.println(prenom);
        }

        int compteur5 = 0;

        System.out.println("Boucle While");

        // TANT QUE (condition == vraie)
        // Utilisation quand on ne connait pas d'avance le nombre d'itération à effectuer
        while (compteur5 < 11) {
            System.out.println("Compteur : " + compteur5);
            compteur5++;
        }

        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.println("Boucle infinie");

        // Création d'une boucle infinie
        while (true) {

            System.out.println("Veuillez saisir 'y' pour sortir de la boucle");

            String valeur = scanner.nextLine();

            if (valeur.equals("y")) {
                break;
            }

        }

        System.out.println("Félicitations vous êtes de sorti de mon piège");

        System.out.println("Do While");

        int nombre = 10;

        do {
            System.out.println(nombre);
            nombre--;
        } while (nombre > 0);

        System.out.println("Instruction continue et break");

        for (int compteur6 = 0; compteur6 < 10; compteur6++) {

            // Le mot clé continue permet de passer à l'itération suivante
            // Les instructions de code suivantes ne seront pas exécutées
            if (compteur6 == 3) {
                continue;
            }

            // le mot clé break permet de sortir de la boucle
            if (compteur6 == 8) {
                break;
            }

            System.out.println(compteur6);
        }
    }
}
