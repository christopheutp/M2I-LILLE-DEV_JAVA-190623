package org.example.exercices.film;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Film laHaine = new Film("La Haine","Mathieu Kassovitz","Drame", LocalDate.of(1995,5,31));
        Film avatar2 = new Film("Avatar 2","James Cameron","Action", LocalDate.of(2022,12,14));

        System.out.println(laHaine);
        System.out.println(avatar2);

    }
}
