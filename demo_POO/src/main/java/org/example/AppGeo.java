package org.example;

import org.example.interfaces.Calculable;
import org.example.interfaces.Cercle;
import org.example.interfaces.Forme;
import org.example.interfaces.Rectangle;

public class AppGeo {
    public static void main(String[] args) {
        Cercle cercle = new Cercle("Cercle 1",5.0);
        Rectangle rectangle = new Rectangle("Rectangle 1",4.0,6.0);

        cercle.afficherDetails();
        rectangle.afficherDetails();

        System.out.println("Aire du cercle :" +cercle.calculerAire());
        System.out.println("Aire du rectancle :" +rectangle.calculerAire());

        System.out.println(Forme.compareAire(cercle,rectangle));

        // Utilisation du polymorphisme avec un tableau de formes
        Forme[] formes = {cercle,rectangle};
        System.out.println();
        System.out.println(" Détail du tableau de Formes");
        for (Forme forme: formes) {
            forme.afficherDetails();
            System.out.println("####################");
        }

        // Utilisation du polymorphisme pour calculer aire totale de mes formes
        double aireTotale = 0.0;
        for (Forme forme: formes) {
            aireTotale += forme.calculerAire();
        }

        System.out.println("Air totale des formes : "+aireTotale);

        System.out.println();
        System.out.println("#################################");
        System.out.println();

        Cercle cercle2 = new Cercle("Cercle 2",8.0);
        Rectangle rectangle2 = new Rectangle("Rectangle 2",8.0,16.0);

        Calculable[] formes2 = {cercle2,rectangle2};

        // Utilisation du polymorphisme pour calculer aire totale de mes formes
        double aireTotale2 = 0.0;
        for (Calculable forme: formes2) {
            aireTotale2 += forme.calculerAire();
        }

        System.out.println("Aire totale des formes 2 : "+ aireTotale2);

        // Utilisation du polymorphisme pour calculer aire totale de mes formes
        for (Calculable forme: formes2) {
          if(forme instanceof Forme){
              // Cast
              ((Forme) forme).afficherDetails();
              System.out.println("########################");
          }
        }



    }




}
