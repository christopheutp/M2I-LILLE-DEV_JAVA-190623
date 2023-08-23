package org.example.classes;

import java.util.ArrayList;

public class Hotel {


    private ArrayList<Client> listeClients;

    private ArrayList<Chambre> listeChambres;

    private ArrayList<Reservation> listeReservations;

    private String nom;

    public Hotel(String nom){
        this.nom = nom;
        this.listeClients = new ArrayList<>();
        this.listeChambres = genListChambres();
        this.listeReservations = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Client> getListeClients() {
        return listeClients;
    }

    public void setListeClients(ArrayList<Client> listeClients) {
        this.listeClients = listeClients;
    }

    public ArrayList<Chambre> getListeChambres() {
        return listeChambres;
    }

    public void setListeChambres(ArrayList<Chambre> listeChambres) {
        this.listeChambres = listeChambres;
    }

    public ArrayList<Reservation> getListeReservations() {
        return listeReservations;
    }

    public void setListeReservations(ArrayList<Reservation> listeReservations) {
        this.listeReservations = listeReservations;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private ArrayList<Chambre> genListChambres(){
        ArrayList<Chambre> genListChambres = new ArrayList<>();
        int min = 10;
        int max = 50;
        int numChambre = 1;
        int randomNumber = (int) (Math.random() * ((max - min) +1)) + min;
        for (int i = 1; i< randomNumber;i++){
            int randomNbLits = (int) (Math.random() * ((4 - 1) +1)) + 1;
            double randomTarif =  Math.random() * (50.0 - 30.0)  + 30.0;
            double roundedTarifArrondi = Math.round(randomTarif * 10.0) / 10.0;
            Chambre chambre = new Chambre(numChambre++,randomNbLits,roundedTarifArrondi);
            genListChambres.add(chambre);
        }
        return genListChambres;
    }

    public boolean ajoutClientHotel(String nom,String prenom,String phone){
       // Client client = new Client(nom,prenom,phone);
        return listeClients.add(new Client(nom,prenom,phone));
    }

    public ArrayList<Reservation> getListReservationsParClient(int idClient){
        ArrayList<Reservation> reservationsClient = new ArrayList<>();
        for (Reservation reservation : listeReservations) {
            if(reservation.getClient().getId() == idClient){
                reservationsClient.add(reservation);
            }
        }
        return  reservationsClient;
    }
}
