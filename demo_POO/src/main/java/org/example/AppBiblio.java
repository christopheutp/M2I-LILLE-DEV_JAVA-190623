package org.example;

import org.example.exercices.biblio.Biblio;
import org.example.exercices.biblio.Livre;

public class AppBiblio {
    public static void main(String[] args) {

        Biblio biblio = new Biblio();
        System.out.println("#####################");
        biblio.afficheAll();
        System.out.println("#####################");

        Livre livre1 = new Livre("Titre 1","Auteur 1",123);
        Livre livre2 = new Livre("Titre 2","Auteur 2",123);
        Livre livre3 = new Livre("Titre 3","Auteur 3",123);
        Livre livre4 = new Livre("Titre 4","Auteur 4",123);
        biblio.addLivre(livre1);
        biblio.addLivre(livre2);
        biblio.addLivre(livre3);
        biblio.addLivre(livre4);
        biblio.addLivre(new Livre("Titre 5","Auteur 5",123));

        biblio.afficheAll();

        System.out.println("##################### Emprunt du livre 4");

        biblio.empruntLivre(livre4);
        biblio.afficheAll();

        System.out.println("##################### Rendre du livre 4");

        biblio.rendreLivre(livre4);
        biblio.afficheAll();

        System.out.println("##################### Suppression du livre 3");

        biblio.removeLivre(livre3);
        biblio.afficheAll();

        System.out.println("##################### Emprunt  du livre  avec Titre 5");

        System.out.println(biblio.empruntLivreParTitre("toto"));
        System.out.println(biblio.empruntLivreParTitre("Titre 5"));

        biblio.afficheAll();


    }
}
