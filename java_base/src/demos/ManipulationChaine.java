package demos;

public class ManipulationChaine {
    public static void main(String[] args) {
        // Création d'une chaîne de manière litteral
        String message = "Hello World!";

        String multiligne = """
                Bonjour je m'appelle Christophe
                j'adore le java
                """;

        // Une chaîne est une série de caractères entre guillemets
        // Il est possible de construire une chaîne à partir d'un tableau de charactères
        char[] hello = {'H', 'e', 'l', 'l', 'o'};
        String chaineHello = new String(hello);
        System.out.println(chaineHello); // Hello

        // Taille d'une chaine
        String palindrome = "Elu par cette crapule";
        int taille = palindrome.length();

        System.out.println(taille);

        // Concaténation de chaînes
        String titre = "Mr ";
        String nom = "Toto";
        String titreNom = titre.concat(nom);
        System.out.println(titreNom);

        String phrase = "Je m'appelle ".concat(nom);
        System.out.println(phrase);

        // Utilisation de l'opérateur mathématique "+"
        String salutation = "Bonjour " + nom + "!";
        System.out.println(salutation);

        // Formater une chaîne de caractère
        // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
        String presentation = String.format("Bonjour, je m'appelle %s, j'ai %d ans, et j'ai %s€ sur mon compte en banque", nom, 18, 150.15);
        System.out.println(presentation);
    }
}
