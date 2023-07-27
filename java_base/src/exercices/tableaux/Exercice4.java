package exercices.tableaux;

public class Exercice4 {
    public static void main(String[] args) {
        // exercice slide 97
        int[] tableau1 = {1, 4, 2, 3};
        int[] tableau2 = {1, 4, 2};
        boolean isEqual = true;

        if (tableau1.length == tableau2.length) {
            for (int indice = 0; indice < tableau1.length; indice++) {
                if (tableau1[indice] != tableau2[indice]) {
                    isEqual = false;
                    break;
                }
            }
        } else {
            isEqual = false;
        }

        if (isEqual) {
            System.out.println("Les tableaux sont égaux");
        } else {
            System.out.println("Les tableaux ne sont pas égaux");
        }
    }
}
