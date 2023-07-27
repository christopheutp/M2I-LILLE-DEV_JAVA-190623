package exercices.conditions;

import java.util.Scanner;

public class Exercice9 {
    public static void main(String[] args) {
        // exercice slide 76
        double temperature;
        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.print("Saisir une température en °C : ");
        temperature = scanner.nextDouble();

        if (temperature >= 100) {
            System.out.println("L'eau est à l'état gazeux");
        } else if (temperature <= 0) {
            System.out.println("L'eau est à l'état solide");
        } else {
            System.out.println("L'eau est à l'état liquide");
        }

        int temperatureInt = (int) temperature;
        System.out.println(temperatureInt);
    }
}
