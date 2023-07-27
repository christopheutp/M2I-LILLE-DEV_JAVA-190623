package exercices.boucles;

import java.util.Scanner;

public class Exercice7 {
    public static void main(String[] args) {
        // exercice slide 84
        int nombre;
        boolean estPremier = true;
        Scanner scanner;

        System.out.println("Saisir un nombre (>1) : ");
        scanner = new Scanner(System.in);
        nombre = scanner.nextInt();

        for(int cpt = 2; cpt < nombre; cpt++){
            if(nombre % cpt == 0){
                estPremier = false;
                break;
            }
        }

        if(estPremier){
            System.out.println("Le nombre est un nombre premier");
        }else {
            System.out.println("Le nombre n'est pas un nombre premier");
        }

    }
}
