package org.example.heritage;

// Utiliusation de mot clé extends pour hériter d'une classe
public class Chat extends Animal{

    private int vies;

    // Appel du constructeur parent
    public Chat(String nom,int age,String couleur){
        // Utilisation du mot clé super pour appeler le constructeur du parent avec ses paramétres
        super(nom, age,couleur);
        this.vies = 7;
    }

    public int getVies() {
        return vies;
    }

    // Surcharge de la méthode parent
    // utilisation de l'annotation @Override
    @Override
    public void crier(){
        System.out.println("Miaou miaou");
    }

    // Surcharge de la méthode parent
    // utilisation de l'ancien comportement avec super.<nom méthode>(<paramétres>)
    @Override
    public void manger(){
        super.manger();
        System.out.println("Je mange de délicieuses croquettes");
    }

    @Override
    public String toString() {
        return "Nom du chat :"+getNom()+" age : "+getAge()+" année de naissance : "+anneeNaissance();
    }
}
