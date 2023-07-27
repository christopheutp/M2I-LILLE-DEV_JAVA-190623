package org.example.exercices.biblio;

import java.util.ArrayList;
import java.util.List;

public class Biblio {

    private ArrayList<Livre> livres;
    // private List<Livre> livres;


    public Biblio() {
        livres = new ArrayList<>();
    }


    public void addLivre(Livre livre){
        livres.add(livre);
    }

    public void removeLivre(Livre livre){
        livres.remove(livre);
    }

    public void afficheAll(){
        for (Livre l : livres){
            System.out.println(l.toString());
        }
    }

    public void empruntLivre(Livre livre){
       // if(livre.isEstEmprunte() == false){
        if(!livre.isEstEmprunte()){
            livre.changeStatus();
        }
    }

    public void rendreLivre(Livre livre){
        if(livre.isEstEmprunte()){
            livre.changeStatus();
        }
    }

}
