package org.example;

import org.example.entities.Produit;
import org.example.services.ProduitService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProduitService ps = new ProduitService();
       // ps.begin();

        // Exercice 1

        // Creation des produits

       /* ps.create(new Produit("TOSHIBA","zzaa123",new Date("2016/01/08"),6000));
        ps.create(new Produit("HP","EER678",new Date("2016/02/09"),2000));
        ps.create(new Produit("SONY","AQWZSX",new Date("2016/09/23"),6000));
        ps.create(new Produit("DELL","AZERTY",new Date("2016/02/12"),6000));
        ps.create(new Produit("SONY","qsdERT",new Date("2016/02/02"),6000));

        // Informations produit id = 2

        Produit p = ps.findById(2);
        System.out.println(p);

        // Supprimer le produit id = 3
        ps.delete(ps.findById(3));

        // Modifier produit id = 1

        p = ps.findById(1);
        if(p != null){
            p.setMarque("HP");
            p.setReference("MMMMPPP");
            p.setDateAchat(new Date("2015/09/08"));
            p.setPrix(5000);
            ps.update(p);
        }*/


        // Exercice 2


       /* System.out.println("############################");
        System.out.println("Afficher tous les produits");
        System.out.println("############################");
        List<Produit> produits = ps.findAll();
        for (Produit pr: produits) {
            System.out.println(pr.getId() + " " + pr.getReference());
        }
        System.out.println("############################");
        System.out.println("produits avec filtre prix");
        System.out.println("############################");

        try{
            List<Produit> produits1 = ps.filterByPrice(4000);
            for (Produit pr: produits1) {
                System.out.println(pr.getId() + " " + pr.getReference());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("############################");
        System.out.println("produits avec filtre date");
        System.out.println("############################");

        try{
            List<Produit> produits2 = ps.filterByDate(new Date("2016/01/20"),new Date("2016/12/23"));
            for (Produit pr: produits2) {
                System.out.println(pr.getId() + " " + pr.getReference());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/

        // Exercice 3
        /*try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Merci de saisir la date 1 (dd/MM/yyyy) : ");
        String s1 = scanner.nextLine();
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(s1);

        System.out.println("Merci de saisir la date 2 (dd/MM/yyyy) : ");
        String s2 = scanner.nextLine();
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(s2);

            List<Produit> produits2 = ps.filterByDate(date1,date2);
            for (Produit pr: produits2) {
                System.out.println(pr.getId() + " " + pr.getReference());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Merci de saisir le stock maximum : ");
            int max = scanner.nextInt();
            List<Produit> produitList = ps.filterByStockMax(max);
            for (Produit pr: produitList) {
                System.out.println(pr.getId() + " " + pr.getReference());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        ps.end();*/

        // Exercice 4

        new Ihm().start();

    }
}