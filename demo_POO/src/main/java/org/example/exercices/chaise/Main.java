package org.example.exercices.chaise;

public class Main {
    public static void main(String[] args) {
        Chaise chaise1 = new Chaise(4,"bleu","chaine",14.4);
        Chaise chaiseGrise = new Chaise(3,"gris","bambou",130.99);
        Chaise chaiseMonoPied = new Chaise(1,"orange","métal",76.25);

        //System.out.println(chaise1);
        // System.out.println(chaiseGrise);
        // System.out.println(chaiseMonoPied);

        chaise1.afficher();
        chaiseGrise.afficher();
        chaiseMonoPied.afficher();
    }
}
