package org.example.classes;

import java.util.ArrayList;

public class Hotel {


    private ArrayList<Client> listeClients;

    private ArrayList<Chambre> listeChambres;

    private ArrayList<Reservation> listeReservations;

    private String nom;

    public Hotel(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
