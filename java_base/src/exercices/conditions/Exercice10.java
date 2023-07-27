package exercices.conditions;

import java.util.Scanner;

public class Exercice10 {
    public static void main(String[] args) {
        // exercice slide 77
        int age;
        double salaire;
        int experience;
        String message;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.print("Saisir un âge : ");
        age = scanner.nextInt();
        System.out.print("\rSaisir un salaire souhaité : ");
        salaire = scanner.nextDouble();
        System.out.print("\rSaisir un nombre d'année d'expériences : ");
        experience = scanner.nextInt();

        message = "";

        if (age <= 30) {
            message = "Vous n'avez pas l'âge requis";
        }

        if (salaire > 34_000) {
            message += "\nVous demandez beaucoup trop d'argent";
        }

        if (experience < 5) {
            message += "\nVous n'avez pas assez d'expérience";
        }
        if(message.isEmpty()){
            System.out.println("Félicitations vous êtes embauché");
        }else {
            System.out.println("Vous n'avez pas été retenu pour les motifs suivants : ");
            System.out.println(message);
        }


    }
}
