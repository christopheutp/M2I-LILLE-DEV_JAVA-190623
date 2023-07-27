package org.example.interfaces;

public class Cercle extends Forme{
    private double rayon;

    public Cercle(String nom, double rayon) {
        super(nom);
        this.rayon = rayon;
    }
    @Override
    public double calculerAire(){
        return Math.PI * rayon * rayon;
    }

    @Override
    public double calculerPerimetre(){
        return 2 * Math.PI * rayon;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Cercle : "+ nom);
        System.out.println("Rayon : "+ rayon);
        System.out.println("Aire : "+ calculerAire());
        System.out.println("Périmètre : "+ calculerPerimetre());
    }
}
