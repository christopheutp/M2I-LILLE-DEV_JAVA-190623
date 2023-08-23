package org.example.classes;

public class Chambre {

    private int num;

    private boolean statut;

    private int nbLits;

    private double tarif;

    public Chambre(int num, int nbLits, double tarif) {
        this.num = num;
        this.nbLits = nbLits;
        this.tarif = tarif;
        this.statut = true;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public int getNbLits() {
        return nbLits;
    }

    public void setNbLits(int nbLits) {
        this.nbLits = nbLits;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "Chambre : " +
                "num=" + num +
                ", statut=" + statut +
                ", nbLits=" + nbLits +
                ", tarif=" + tarif +
                '.';
    }
}
