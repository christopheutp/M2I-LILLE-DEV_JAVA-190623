package org.example.ihm;

import org.example.classes.Chambre;
import org.example.classes.Hotel;

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
        System.out.println("Ici je m'occupe de la methodologie pour ajouter un client");
        System.out.println();
    }

    public static void afficherClients(){
        System.out.println();
        System.out.println("Ici je m'occupe de la methodologie pour afficher les clients");
        System.out.println();

    }
    public static void afficherReservationsClient(){
        System.out.println();
        System.out.println("Ici je m'occupe de la methodologie pour afficher les reservations clients");
        System.out.println();

    }
    public static void ajoutReservation(){
        System.out.println();
        System.out.println("Ici je m'occupe de la methodologie pour ajouter une reservation");
        System.out.println();

    }

    public static void annulerReservation(){
        System.out.println();
        System.out.println("Ici je m'occupe de la methodologie pour annuler une reservation");
        System.out.println();

    }

    public static void afficherReservations(){
        System.out.println();
        System.out.println("Ici je m'occupe de la methodologie pour afficher toutes les reservations");
        System.out.println();

    }





}
