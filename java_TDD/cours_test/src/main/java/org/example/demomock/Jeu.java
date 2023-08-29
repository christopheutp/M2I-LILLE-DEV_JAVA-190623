package org.example.demomock;

public class Jeu {
    private De de;

    public Jeu(De de) {
        this.de = de;
    }

    public boolean jouer() {
        if(de.getValue() == 6) {
            System.out.println("Bravo");
            return true;
        }
        System.out.println("Désolé");
        return false;
    }
}
