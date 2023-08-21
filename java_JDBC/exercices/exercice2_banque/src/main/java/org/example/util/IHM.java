package org.example.util;

import org.example.model.BankAccount;
import org.example.model.Customer;
import org.example.model.Operation;
import org.example.service.BankService;

import java.util.Scanner;

public class IHM {

    private Scanner scanner;

    private String choix;

    private BankService bankService;

    public IHM(){
        scanner = new Scanner(System.in);
        bankService = new BankService();
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
        Customer customer = createCustomerAction();
        if(customer != null) {
            BankAccount bankAccount = bankService.createAndSaveAccount(customer.getId());
            if (bankAccount != null){
                System.out.println("Compte crée avec l'id "+bankAccount.getId());
            }
        }
    }

    public void depositAction(){
        System.out.println();
        System.out.println("=== Faire un dépot sur un Compte ===");
        System.out.println();
        System.out.print("Merci de saisir l'id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = bankService.getAccountAction(id);
        System.out.print("Merci de saisir le montant du dépôt : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        if(bankAccount != null){
            if (bankService.makeOperationDeposit(montant,bankAccount.getId())){
                System.out.println("dépot réussi");
            }else {
                System.out.println("erreur");
            }
        }
    }

    public void withDrawlAction(){
        System.out.println();
        System.out.println("=== Faire un retrait sur un Compte ===");
        System.out.println();
        System.out.print("Merci de saisir l'id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = bankService.getAccountAction(id);
        System.out.print("Merci de saisir le montant du dépôt : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        if(bankAccount != null){
            if(bankService.makeOperationWithDraw(montant*-1, bankAccount.getId())){
                System.out.println("retrait réussi");
            }else {
                System.out.println("erreur");
            }
        }

    }

    private Customer createCustomerAction(){
        System.out.println();
        System.out.println("=== Création d'un Client ===");
        System.out.println();
        Customer customer = null;
        System.out.print("Merci de saisir le nom : ");
        String lastName = scanner.nextLine();
        System.out.print("Merci de saisir le prénom : ");
        String firstName = scanner.nextLine();
        System.out.print("Merci de saisir le téléphone : ");
        String phone = scanner.nextLine();
        customer = bankService.createAndSaveCustomer(firstName,lastName,phone);
        return customer;

    }

    public void getAccountOperations(){
        System.out.println();
        System.out.println("=== Voir toutes les opérations d'un Compte ===");
        System.out.println();
        System.out.print("Merci de saisir l'id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = bankService.getAccountAction(id);
        if(bankAccount != null){
            for (Operation op : bankService.getAllOpertionByIdAccount(bankAccount.getId())) {
                System.out.println(op);
            }
            System.out.println("solde compte actuelle :"+bankAccount.getTotalAmount());
        }
    }
}
