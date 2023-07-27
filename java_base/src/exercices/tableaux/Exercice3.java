package exercices.tableaux;

public class Exercice3 {
    public static void main(String[] args) {
// exercice slide 96
        int[] tableau = {23, 150, 12, 28, 2900, 2};
        int max = 0;
        int indMax = 0;

        for (int indice = 0; indice < tableau.length; indice++) {

            if (indice == 0) {
                max = tableau[indice];
            } else if (tableau[indice] > max) {
                max = tableau[indice];
                indMax = indice;
            }

        }

        System.out.printf("La valeur max est : %d à l'indice : %d", max, indMax);

    }
}
