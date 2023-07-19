package demos;

public class Variables {
    public static void main(String[] args) {
        /***************
         Types primitifs
         https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
         ***************/

        // Déclaration d'une variable
        // <type> <nom>;
        // int : entier sur 32 bits
        int age;

        // long : entier sur 64 bits
        long indice;

        // float : précision sur 32 bits
        float distance;

        // double : précision sur 64 bits
        double monnaie;

        // boolean : true ou false
        boolean estVrai;

        // correspond à un caractère
        char lettre;

        // Chaîne de caractère
        // String n'est pas considéré comme un type primitif
        String prenom;

        // <type> <nom> = <valeur>;
        int jour = 5;

        // Affectation
        age = 24;
        indice = 100_000_000;
        distance = 12.74f;
        monnaie = 15.5;
        estVrai = false;
        lettre = 'a';
        prenom = "Arthur";

        double resulat = age + monnaie;

        // println() permet d'afficher des enregistrements dans la console
        System.out.println(resulat);

        System.out.println(prenom + " a " + age + " ans");

        System.out.println(age);
        System.out.println(indice);
        System.out.println(distance);
        System.out.println(monnaie);
        System.out.println(estVrai);
        System.out.println(lettre);
        System.out.println(prenom);


        // Les types énumérés (enum)
        enum JourSemaine {
            LUNDI, MARDI, MERCREDI, JEUDI, Vendredi, SAMEDI, DIMANCHE
        }

        JourSemaine today = JourSemaine.Vendredi;

        System.out.println(today);
    }
}
