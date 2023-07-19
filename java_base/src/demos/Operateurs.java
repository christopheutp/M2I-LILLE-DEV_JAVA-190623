package demos;

public class Operateurs {
    public static void main(String[] args) {
        //region Opérateurs arithmétiques
        int result = 1 + 2;

        System.out.println("1 + 2 = " + result); // 3
        int original_result = result;

        result = result - 1;

        System.out.println(original_result + " - 1 = " + result); // 2
        original_result = result;

        result = result * 2;

        System.out.println(original_result + " * 2 = " + result); // 4
        original_result = result;

        result = result / 2;

        System.out.println(original_result + " / 2 = " + result); // 2
        original_result = result;

        result = result + 8;

        System.out.println(original_result + " + 8 = " + result); // 8
        original_result = result;

        result = result % 7;

        System.out.println(original_result + " % 7 = " + result); // 3
        //endregion

        //region Opérateurs unaires
        int nombre = +1;

        System.out.println(nombre); // 1

        // opérateur de décrémentation (-1)
        nombre--;

        System.out.println(nombre); // 0

        // opérateur d'incrémentation (+1)
        nombre++;

        System.out.println(nombre); // 1

        ++nombre;

        System.out.println(nombre); // 2

        // Opérateur de négation unaire
        nombre = -nombre;

        System.out.println(nombre); // -2

        // Opérateur Not
        boolean success = false;

        System.out.println(success); // false

        System.out.println(!success); // true
        //endregion

        //region Affectations composées
        int x = 5; // x est égal à 5

        // Incrementation
        x += 5; // x = x + 5;

        // Decrementation
        x -= 2; // x = x -2;

        // Multiplication
        x *= 2; // x = x * 2;

        // Modulo
        x %= 3; // x = x % 3;
        //endregion

        //region Opérateurs d'égalité et relationnels
        int value1 = 1;
        int value2 = 2;
        boolean resultat;

        resultat = value1 == value2;
        System.out.printf("value1 == value2 : %s \n", resultat);

        resultat = value1 != value2;
        System.out.printf("value1 != value2 : %s \n", resultat);

        resultat = value1 > value2;
        System.out.printf("value1 > value2 : %s \n", resultat);

        resultat = value1 < value2;
        System.out.printf("value1 < value2 : %s \n", resultat);

        resultat = value1 <= value2;
        System.out.printf("value1 <= value2 : %s \n", resultat);
        //endregion

        //region Opérateurs conditionnels
        // ET : les deux conditions doivent être vraies
        resultat = (value1 == 1) && (value2 == 2);
        System.out.printf("value1 is 1 AND value2 is 2 : %s \n", resultat);

        // OU : l'une, l'autre ou les deux doivent être vraies
        resultat = (value1 == 1) || (value2 == 2);
        System.out.printf("value1 is 1 OR value2 is 2 : %s \n", resultat);
        //endregion
    }
}
