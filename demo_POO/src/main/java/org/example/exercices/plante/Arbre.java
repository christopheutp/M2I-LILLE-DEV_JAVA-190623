package org.example.exercices.plante;

public class Arbre extends Plante{

    private double circonference;

    public Arbre(String nom, double hauteur, String couleurFeuille,double circonference) {
        super(nom, hauteur, couleurFeuille);
        this.circonference = circonference;
    }

    public double getCirconference() {
        return circonference;
    }

    public void setCirconference(double circonference) {
        this.circonference = circonference;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println(" et je suis un arbre de circonférence : "+this.circonference);
    }
}
