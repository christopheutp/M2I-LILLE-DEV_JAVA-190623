package org.example.exercices.plante;

public class Plante {
    private String nom;
    private double hauteur;
    private String couleurFeuille;

    public Plante(String nom, double hauteur, String couleurFeuille) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleurFeuille = couleurFeuille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleurFeuille() {
        return couleurFeuille;
    }

    public void setCouleurFeuille(String couleurFeuille) {
        this.couleurFeuille = couleurFeuille;
    }

    public void afficher(){
        System.out.print("Plante de nom : "+this.nom+" de hauteur : "
                +this.hauteur+" et de couleur de feuilles : "
                +this.couleurFeuille);
    }
}
