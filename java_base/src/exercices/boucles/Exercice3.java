package exercices.boucles;

public class Exercice3 {
    public static void main(String[] args) {
        // exercice slide 80
        // Itère sur les tables
        for (int table = 1; table < 11; table++) {
            System.out.printf("Table %d\n", table);
            // Itère de 1 à 10 et se multiplie par la table
            for (int mult = 1; mult < 11; mult++) {
                System.out.printf("\t%d x %d = %d\n", table, mult, table * mult);
            }

        }
    }
}
