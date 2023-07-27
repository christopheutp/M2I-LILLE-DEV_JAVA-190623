package org.example.exercices.biblio;

public class Livre {
    private String titre;
    private String auteur;
    private int nbPages;
    private boolean estEmprunte;

    public Livre(String titre, String auteur, int nbPages) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.estEmprunte = false;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public boolean isEstEmprunte() {
        return estEmprunte;
    }

    public void setEstEmprunte(boolean estEmprunte) {
        this.estEmprunte = estEmprunte;
    }

    @Override
    public String toString() {
        return "Livre : " +
                "titre = '" + titre + '\'' +
                ", auteur = '" + auteur + '\'' +
                ", nbPages = " + nbPages +
                ", estEmprunte = " + estEmprunte +
                '.';
    }

    public void changeStatus(){
        this.estEmprunte = !this.estEmprunte;
    }
}
