package org.example.base;

public class Voiture {

    // Attributs d'instance
    // <visibilité> <type> <nom>
    // public = accesible en dehors de la classe
    public String couleur;
    public int carburant;
    public int puissance;
    // private : accessible uniquement dans la classe
    private String marque;
    // protected : accessible dans la classe et dans les enfants qui héritent de cette classe
    protected int nombrePortes;

    // Constructeur
    // Défini comment est construit la classe
    public Voiture() {
        System.out.println("Je suis dans le constructeur sans paramétre");
    }

    // Polymorphisme : possibilité de définir plusieurs méthode avec le méme nom mais des signature différentes
    public Voiture(String couleur){
        // this(<parametres>) appelle le constructeur avec la signature similaire
        this();
        System.out.println("Je suis dans le constructeur avec la couleur");
        this.couleur = couleur;
    }

    public Voiture(String couleur, int carburant, int puissance){
       // this.couleur = couleur;
        this(couleur);
        this.carburant = carburant;
        this.puissance = puissance;
        System.out.println("Je suis dans le constructeur avec tous les attributs");
    }

    // Méthodes d'instance

    // <visibilité> <type de retour> <nom> (<parmétres)
    public void demarrer(){
        System.out.println("La voiture démarre");
    }

    public void freiner(){
        System.out.println("La voiture freine");
    }

    public void remplirReservoir(int volume){
        carburant += volume;
    }

    public double puissanceChevauxFiscaux(){
        return puissance / 7.;
    }

    @Override
    public String toString() {
        return "Voiture :" +
                "couleur='" + couleur + '\'' +
                ", carburant=" + carburant +
                ", puissance=" + puissance +
                ", marque='" + marque + '\'' +
                ", nombrePortes=" + nombrePortes +
                '.';
    }

    public String afficherDetails() {
        return "Voiture :" +
                "couleur='" + couleur + '\'' +
                ", carburant=" + carburant +
                ", puissance=" + puissance +
                ", marque='" + marque + '\'' +
                ", nombrePortes=" + nombrePortes +
                '.';
    }

    // Destructeur
    protected void finalize(){

    }


}
