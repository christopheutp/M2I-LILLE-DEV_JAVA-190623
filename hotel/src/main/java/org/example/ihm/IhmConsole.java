package org.example.ihm;

import org.example.classes.Chambre;
import org.example.classes.Client;
import org.example.classes.Hotel;
import org.example.classes.Reservation;

import java.util.ArrayList;
import java.util.Scanner;

public class IhmConsole {

    private static Scanner scanner = new Scanner(System.in);

    private static Hotel hotel;


    public static void start() {
        System.out.println("Quelle est le nom de l'hôtel ? ");
        String nomHotel = scanner.nextLine();
        hotel = new Hotel(nomHotel);
        System.out.println(hotel.getNom()+ " crée avec succés ! ");
        System.out.println("Hôtel crée avec "+ hotel.getListeChambres().size() +" chambres ");
        for (Chambre chambre : hotel.getListeChambres()) {
            System.out.println(chambre);
        }
        afficherMenu();
    }

    public static void afficherMenu(){
        int choix;

        do {
            System.out.println("=== Menu principal ===");
            System.out.println();
            System.out.println("1. Ajouter un client");
            System.out.println("2. Afficher la liste des clients");
            System.out.println("3. Afficher les réservations d'un clients");
            System.out.println("4. Ajouter une réservation");
            System.out.println("5. Annuler une réservation");
            System.out.println("6. Afficher la liste des réservations");
            System.out.println("0. Quitter");
            System.out.println("Votre choix :");

            choix= scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajoutClient();
                    break;
                case 2:
                    afficherClients();
                    break;
                case 3 :
                    afficherReservationsClient();
                    break;
                case 4 :
                    ajoutReservation();
                    break;
                case 5 :
                    annulerReservation();
                    break;
                case 6 :
                    afficherReservations();
                    break;
                case 0 :
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un choix valide !!!!");

            }


        }while (choix != 0);

        scanner.close();

    }


    public static void ajoutClient(){
        System.out.println();
        System.out.println("=== Menu principal ===");
        System.out.println();
        System.out.println("Quel est le nom du client :");
        String nomClient = scanner.nextLine();
        System.out.println("Quel est le prenom du client :");
        String prenomClient = scanner.nextLine();
        System.out.println("Quel est le telephone du client :");
        String phoneClient = scanner.nextLine();
        if(hotel.ajoutClientHotel(nomClient,prenomClient,phoneClient)){
            System.out.println("Client ajouté avec succés");
        }else{
            System.out.println("erreur");
        }
    }

    public static void afficherClients(){
        System.out.println();
        System.out.println("=== Afficher les clients ===");
        System.out.println();
        for (Client client : hotel.getListeClients()) {
            System.out.println(client);
        }

    }
    public static void afficherReservationsClient(){
        System.out.println();
        System.out.println("=== Afficher les Reservations d'un client ===");
        System.out.println();
        System.out.println(" Quel client ? (taper le numéro)");
        int idClient = scanner.nextInt();
        for (Reservation reservation : hotel.getListReservationsParClient(idClient)) {
            System.out.println(reservation);
        }

    }
    public static void ajoutReservation(){
        System.out.println();
        System.out.println("=== Ajouter une reservation ===");
        System.out.println();
        afficherClients();
        System.out.println(" Pour quel client ? (taper le numéro)");
        int idClient = scanner.nextInt();
        System.out.println(" Combien de chambre ? ");
        int nbChambre = scanner.nextInt();
        int[] tabNumChambres = new int[nbChambre];
        boolean dispoChambre= true;
        for (int i = 0 ; i < tabNumChambres.length; i++){
            int selectChambre;
            do {
                System.out.println("Taper le numéro d'une chambre disponible :");
                selectChambre = scanner.nextInt();
                dispoChambre = hotel.getListeChambres().get(selectChambre-1).isStatut();
                System.out.println(dispoChambre);
            }while(!dispoChambre);
            tabNumChambres[i]= selectChambre;
        }

        Client client = hotel.getListeClients().get(idClient);
        ArrayList<Chambre> chambres = new ArrayList<>();
        for(int i = 0 ; i < tabNumChambres.length; i++){
            chambres.add(hotel.getListeChambres().get(tabNumChambres[i]-1));
            hotel.getListeChambres().get(tabNumChambres[i]-1).setStatut(false);
        }
        hotel.getListeReservations().add(new Reservation(chambres,client));

    }

    public static void annulerReservation(){
        System.out.println();
        System.out.println("=== Annuler une reservation ===");
        System.out.println();
        System.out.println("Quelle reservation annuler / terminer ? (taper le numero)");
        int idReservation = scanner.nextInt();
        hotel.getListeReservations().get(idReservation).setStatut(false);
        for (Chambre chambre : hotel.getListeReservations().get(idReservation).getListeChambres()) {
            chambre.setStatut(true);
        }

    }

    public static void afficherReservations(){
        System.out.println();
        System.out.println("=== Afficher les Reservations ===");
        System.out.println();
        for (Reservation reservation : hotel.getListeReservations()) {
            System.out.println(reservation);
        }


    }





}
