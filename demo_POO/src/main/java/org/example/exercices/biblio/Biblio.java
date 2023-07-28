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
       // for (Livre l : livres){
       //     System.out.println(l.toString());
      //  }
        for(int i=0; i < livres.size();i++){
            System.out.println((i+1)+") "+livres.get(i).toString());
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

    public String empruntLivreParTitre(String titre){
        for(int i=0; i < livres.size();i++){
            if(livres.get(i).getTitre().equals(titre)){
                livres.get(i).changeStatus();
                return "Livre "+livres.get(i).getTitre()+ " emprunté";
            }
        }
    return "Le livre "+titre+" n'est pas présent dans la biblio";
    }

}
