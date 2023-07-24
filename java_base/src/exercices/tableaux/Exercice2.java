package exercices.tableaux;

import java.util.Arrays;

public class Exercice2 {
    public static void main(String[] args) {

        int[] tableauSource = {-5, 3, 24, -12, -10, 5, 100, -2, -71, 0};
        int[] tableauDestination = new int[10];
        int compteur = 0;

        for (int valeur : tableauSource) {
            if (valeur > 0) {
                tableauDestination[compteur] = valeur;
                compteur++;
            }
        }

        System.out.println(Arrays.toString(tableauDestination));

    }
}
