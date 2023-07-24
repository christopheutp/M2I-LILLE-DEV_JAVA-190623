package demos;

public class Tableaux {
    public static void main(String[] args) {
        // Déclaration d'un tableau
        int[] ages;

        // Allocation de la mémoire pour 5 éléments
        ages = new int[5];

        ages[0] = 10;
        ages[1] = 20;
        ages[2] = 30;
        ages[3] = 40;
        ages[4] = 50;

        System.out.println("Element à l'index 0: " + ages[0]);
        System.out.println("Element à l'index 1: " + ages[1]);
        System.out.println("Element à l'index 2: " + ages[2]);
        System.out.println("Element à l'index 3: " + ages[3]);
        System.out.println("Element à l'index 4: " + ages[4]);

        System.out.println("Parcour du tableau avec boucle for");
        for(int i=0; i < ages.length;i++){
            System.out.println("Element à l'index "+i+": " + ages[0]);
        }

        byte[] tableauOctet;
        short[] tableauShort;
        long[] tableauLong;
        float[] tableauFloat;
        double[] tableauDouble;
        boolean[] tableauBoolean;
        char[] tableauChar;
        String[] tableauChaine;

        // Déclaration et initialisation
        char[] caracteres = new char[10];

        // Synthaxe pour déclarer et allouer directement le tableau
        int[] annees = {2020, 2021, 2022, 2023};

        // Tableau multi-dimensionnels
        String[][] titresNoms = {
                {"Mr ", "Mme ", "Mlle "},
                {"Dupont", "Legrand"}
        };
        System.out.println(titresNoms[0][0] + titresNoms[1][0]); // Mr Dupont
        System.out.println(titresNoms[0][2] + titresNoms[1][1]); // Mme Legrand

        // Accéder à la taille d'un tableau
        System.out.println(titresNoms.length);

    }
}
