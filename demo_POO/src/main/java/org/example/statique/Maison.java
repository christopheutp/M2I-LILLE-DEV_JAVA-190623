package org.example.statique;

public class Maison {
    private String couleur;
    private int nombrePortes;
    private double largeur;
    private double longueur;

    // Attributs de classe : commun à toute les instances
    // <visibilité> static <type> <nom>
    // si il est en public <Classe>.<attribut>
    private static int nombreMaisons;
    public static String nomLatin = "Domus";

    public Maison(String couleur, int nombrePortes, double largeur, double longueur) {
        nombreMaisons++;
        this.couleur = couleur;
        this.nombrePortes = nombrePortes;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        if (couleur != "Rouge"){
            this.couleur = couleur;
        }
    }

    public int getNombrePortes() {
        return nombrePortes;
    }

    public void setNombrePortes(int nombrePortes) {
        this.nombrePortes = nombrePortes;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }


    // <vsibilité> static <type de retour> <nom>(<paramétres)
    public static int getNombreMaisons() {
        return nombreMaisons;
    }


}
