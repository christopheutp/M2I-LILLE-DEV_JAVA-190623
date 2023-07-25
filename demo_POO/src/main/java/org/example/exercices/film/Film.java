package org.example.exercices.film;

import java.time.LocalDate;

public class Film {
    private String titre;
    private String realisateur;
    private String genre;
    private LocalDate dateSortie;


    public Film(String titre, String realisateur, String genre, LocalDate dateSortie) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.genre = genre;
        this.dateSortie = dateSortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", genre='" + genre + '\'' +
                ", dateSortie=" + dateSortie +
                '}';
    }
}
