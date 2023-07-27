package exercices.boucles;

import java.util.Scanner;

public class Exercice10 {
    public static void main(String[] args) {
        // exercice slide 87
        Scanner scanner = new Scanner(System.in);

        System.out.print("Saisir un nombre : ");

        int nbEntre  = scanner.nextInt();
        int saveNb = nbEntre;

        int sum = 0;

        while (nbEntre > 0) {

            int dernierchiffre = nbEntre % 10;

            int resFacto = 1;
            for (int i = dernierchiffre; i > 1; i--) {
                resFacto *= i;
            }

            sum += resFacto;

            nbEntre /= 10;
        }

        if (sum == saveNb) {
            System.out.printf("%d est un chiffre fort !", saveNb);
        } else {
            System.out.printf("%d n'est pas un chiffre fort...", saveNb);
        }
    }
}
