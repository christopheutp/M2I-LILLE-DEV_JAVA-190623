package org.example.util;

import java.util.Scanner;

public class IHM {

    private Scanner scanner;

    private String choix;

    public IHM(){
        scanner = new Scanner(System.in);

    }

    public void start(){
        System.out.println("Exercice : Programme Banque");
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix){
                case "1":
                    createAccountAction();
                    break;
                case "2":
                    depositAction();
                    break;
                case "3":
                    withDrawlAction();
                    break;
                case "4":
                    getAccountOperations();
                    break;
                case "0":
                    System.out.println("Aurevoir");
                    break;
                default:
                    System.out.println("choix invalide");

            }
        }while (!choix.equals("0"));

    }

    private void menu(){
        System.out.println("=== Menu BANQUE ===");
        System.out.println("1 - Création d'un client et un compte");
        System.out.println("2 - Dépot");
        System.out.println("3 - Retrait");
        System.out.println("4 - Afficher les opérations d'un compte");
        System.out.println("0 - Quitter");
    }

    public void createAccountAction(){
        System.out.println();
        System.out.println("=== Création d'un Compte ===");
        System.out.println();
    }

    public void depositAction(){
        System.out.println();
        System.out.println("=== Faire un dépot sur un Compte ===");
        System.out.println();
    }

    public void withDrawlAction(){
        System.out.println();
        System.out.println("=== Faire un retrait sur un Compte ===");
        System.out.println();

    }

    private void createCustomerAction(){
        System.out.println();
        System.out.println("=== Création d'un Client ===");
        System.out.println();

    }

    public void getAccountOperations(){
        System.out.println();
        System.out.println("=== Voir toutes les opérations d'un Compte ===");
        System.out.println();
    }
}
