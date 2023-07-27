package org.example.liste;

import java.util.ArrayList;

public class MainListe {
    public static void main(String[] args) {
        // ArrayList<type> <nom> = new ArrayList<type>();
        ArrayList<String> prenoms = new ArrayList<String>();

        // la méthode add() permet d'ajouter un élement à la liste
        prenoms.add("Sophie");
        prenoms.add("Toto");
        prenoms.add("Dorian");

        // la méthode get permet d'acceder à un element par son indice
        System.out.println(prenoms.get(0));
        System.out.println(prenoms.get(1));
        System.out.println(prenoms.get(2));

        // La méthode set permet de modifier un élement en précisant son index
        prenoms.set(1,"Asma");

        // la méthode size() permet de retourner la taille de la liste
        System.out.println("Taille de ma liste : "+prenoms.size());

        // // la méthode remove permet de supprimer un élément
        prenoms.remove(2);

        // la méthode size() permet de retourner la taille de la liste
        System.out.println("Taille de ma liste : "+prenoms.size());

        // la boucle foreach permet de parcourir la liste
        for (String prenom : prenoms){
            System.out.println(prenom);
        }

        // Possibilité de parcourir avec la boucle for
        for(int i = 0; i < prenoms.size(); i++){
            System.out.println(prenoms.get(i));
        }


    }
}
