package exercices.boucles;

import java.util.Scanner;

public class Exercice8 {
    public static void main(String[] args) {
        // exercice slide 85
        int nombreMystere = (int) Math.round(Math.random() * 100) + 1;
        int nbEssais = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nVeuillez entrer un nombre : ");
            int nombreEntre = scanner.nextInt();
            nbEssais++;

            if (nombreEntre == nombreMystere) {
                break;
            } else if (nombreEntre > nombreMystere) {
                System.out.println("Trop grand !");
            } else {
                System.out.println("Trop petit !");
            }



        }

        System.out.printf("Bravo, vous avez trouvé le nombre mystère en %d essais !", nbEssais);
    }
}
