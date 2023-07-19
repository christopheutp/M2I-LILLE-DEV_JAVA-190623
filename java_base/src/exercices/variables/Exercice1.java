package exercices.variables;

import java.util.Scanner;

public class Exercice1 {
    public static void main(String[] args) {
        /* slide 51
        Exercice : Prénom nom
        1. Créer une variable nom et une variable prenom
        2. Afficher la phrase suivante "Bonjour {prenom} {NOM}."
        3. Remplacer les valeurs entre chevrons par les variables créées
        précédemment
         */

        // Permet de récupérer des entrées en console
        Scanner scanner = new Scanner(System.in);

        String prenom;
        String nom;

        // Affichage de message
        System.out.print("Saisir un prenom : ");
        // récupération de la valeur saisie dans la console
        prenom = scanner.nextLine();

        // \n permet de faire un retour à la ligne
        System.out.print("\nSaisir un nom : ");
        nom = scanner.nextLine();

        System.out.println("Bonjour " + prenom.substring(0,1).toUpperCase() + prenom.substring(1).toLowerCase() + " " + nom.toUpperCase() + ".");

    }
}
