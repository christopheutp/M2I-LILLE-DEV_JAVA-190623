package demos;

import java.util.Scanner;

public class LeScanner {
    public static void main(String[] args) {
        // les différents print ( print , println, printf )

        // snippet sout
        System.out.println("Bonjour à tous !!!"+ "Comment allez-vous ?");
        System.out.println("Comment allez-vous ?");

        System.out.print("Bonjour à tous !!!" + "Comment allez-vous ?");
        System.out.print("Comment allez-vous ?");

        int age = 25;
        double poids = 65.75;
        String nom = "John Doe";

        // \n pour saut de ligne

        System.out.printf("\nNom: %s, Age: %d, Poids: %.2f kg\n", nom, age, poids);
        System.out.printf("\nNom: %s, Age: %d, Poids: %.2f kg\n", nom, age, poids);

        // \t pour tabulation
        System.out.println("Texte avec une tabulation\tet rien d'autre");


        // \b pour backspace
        System.out.println("Hello\bWorld"); // HellWorld


        // L'objet Scanner
        Scanner scanner = new Scanner(System.in);

        // les différents next de scanner
        // Demande le nom de l'utilisateur
        System.out.print("Quel est votre nom ? ");
        String nomUtilisateur = scanner.nextLine();

        // Utilisation de printf pour formater la sortie
        System.out.printf("Bonjour, %s! Bienvenue dans notre programme interactif.%n", nomUtilisateur);

        // Demande l'âge de l'utilisateur
        System.out.print("Quel âge avez-vous ? ");
        int ageUtilisateur = scanner.nextInt();

        // Utilisation de println pour afficher une nouvelle ligne
        System.out.println();

        // Utilisation de print pour afficher sans nouvelle ligne
        System.out.print("Vous avez ");

        // Utilisation de printf pour formater la sortie avec l'âge
        System.out.printf("%d an", ageUtilisateur);
        System.out.print("s");
        System.out.println(".");

        // Utilisation de nextDouble pour lire un nombre décimal
        System.out.print("Entrez un nombre décimal : ");
        double decimal = scanner.nextDouble();
        System.out.println("Le nombre décimal que vous avez entré est : " + decimal);

        // Utilisation de nextBoolean pour lire une valeur booléenne
        System.out.print("Êtes-vous un étudiant ? (true/false) ");
        boolean estEtudiant = scanner.nextBoolean();
        System.out.println("Statut étudiant : " + estEtudiant);

        // Utilisation de nextLine pour vider le tampon après nextBoolean
        scanner.nextLine();

        // Utilisation de nextLine pour lire une chaîne de caractères
        System.out.print("Quel est votre hobby ? ");
        String hobby = scanner.nextLine();
        System.out.println("Votre hobby est : " + hobby);

        System.out.println("saisir du texte avec espace");
        String texte = scanner.next();
        System.out.println(texte);

        // Utilisation de nextLine pour vider le tampon après next
        scanner.nextLine();

        System.out.println("saisir un caractere");
        char caractere = scanner.next().charAt(0);
        System.out.println(caractere);

        // Fermeture du scanner
        // en bonne pratique le scanner est sensé etre ferme (mais rarement le cas)
        // attention une fois le scanner ferme il ne peut plus etre utilisé
        scanner.close();
    }
}
