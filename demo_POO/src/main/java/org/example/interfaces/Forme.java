package org.example.interfaces;

public abstract class Forme implements Calculable {

   protected String nom;

   public Forme(String nom){
       this.nom = nom;
   }

   public abstract void afficherDetails();

    @Override
    public double calculerAire() {
        return 0.0;
    }

    public static String compareAire(Forme forme1, Forme forme2){
        double aire1 = forme1.calculerAire();
        double aire2= forme2.calculerAire();
        if(aire1 > aire2){
            return forme1.nom+ " a une plus grande aire que "+forme2.nom;
        } else if (aire2 > aire1) {
            return forme2.nom+ " a une plus grande aire que "+forme1.nom;
        }else {
            return "Les deux formes ont la même aire";
        }
    }
}
