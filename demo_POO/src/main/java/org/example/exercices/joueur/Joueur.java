package org.example.exercices.joueur;

public class Joueur {
    private String nom;
    private int niveau;
    private int xp;

    public Joueur(String nom) {
        this.nom = nom;
        this.niveau = 1;
        this.xp = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getXp() {
        return xp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void effectuerUneQuete() {
        this.xp += 10;
        levelUp();
    }

    private void levelUp() {
        if (this.xp >= 100) {
            this.niveau++;
            this.xp = 0;
            System.out.printf("Le joueur: %s passe au niveau %d !\n", nom, niveau);
        }
    }
}
