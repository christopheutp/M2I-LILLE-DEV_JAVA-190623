package exercices.conditions;

import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {

        int age;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.printf("Saisir un âge : ");
        age = scanner.nextInt();

        if (age >= 18) {
            System.out.println("\rVous êtes majeur, vous pouvez rentrer au macumba");
        } else {
            System.out.println("Vous ne pouvez pas rentrer. Allez regarder des dessins animés");
        }

    }

}
