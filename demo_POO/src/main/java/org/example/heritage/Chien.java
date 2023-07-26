package org.example.heritage;

public class Chien extends Animal{

    private double taille;

    public Chien(String nom, int age, String couleur,double taille) {
        super(nom, age, couleur);
        this.taille = taille;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    @Override
    public void crier() {
        System.out.println("Wouf Wouf");
    }

    @Override
    public void manger(){
        super.manger();
        System.out.println("Je mange de la bonne paté pour chien");
    }


}
