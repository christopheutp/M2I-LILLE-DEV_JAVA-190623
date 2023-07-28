package org.example.exceptions;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Compte cp = new Compte();
        Scanner clavier = new Scanner(System.in);
        System.out.print("Montant à verser:");
        float mt1;
        mt1=clavier.nextFloat();
        cp.verser(mt1);
        System.out.println("Solde Actuel:"+cp.getSolde());
        System.out.print("Montant à retirer:");
        float mt2=clavier.nextFloat();

        // cp.retirer(mt2); // le compilateur signal l'exception

        // solution

        try{
            cp.retirer(mt2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Solde final ="+cp.getSolde());
    }
}
