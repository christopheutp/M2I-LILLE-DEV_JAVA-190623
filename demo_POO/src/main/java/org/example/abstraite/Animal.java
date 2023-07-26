package org.example.abstraite;

// Une classe abstraite se déclare avec le mot clé abstract
public abstract class Animal {
    protected String nom;
    protected int age;
    protected String couleur;

    public Animal(String nom, int age, String couleur) {
        this.nom = nom;
        this.age = age;
        this.couleur = couleur;
    }

    // On peut définir des signature de méthodes en abstract
    // Les méthodes devront etre surchargées dans les classes enfants
    public abstract void crier();

    public void manger(){
        System.out.println("miam miam je mange");
    }

}
