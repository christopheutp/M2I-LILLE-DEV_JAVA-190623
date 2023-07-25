package org.example.exercices.chaise;

public class Chaise {
    private int nombrePieds;
    private String couleur;
    private String materiaux;
    private double prix;

    public Chaise() {
    }

    public Chaise(int nombrePieds, String couleur, String materiaux,double prix) {
        this.nombrePieds = nombrePieds;
        this.couleur = couleur;
        this.materiaux = materiaux;
        this.prix = prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Je suis une chaise avec "+nombrePieds+" pied(s) en "+materiaux+" de couleur "+couleur+" à un prix de "+prix;
    }

    public void afficher(){
        System.out.println(this.toString());
    }
}
