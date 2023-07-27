package exercices.boucles;

public class Exercice4 {

    public static void main(String[] args) {
        // exercice slide 81
        int annee = 2015;
        double population = 96_809;

        while (population < 120_000) {
            population *= 1.0089;
            annee++;
        }

        System.out.printf("La population de Tourcoing dépassera les 120 000 habitants en %s pour %s habitants", annee, (int) Math.ceil(population));
    }

}
