package org.example;

import org.example.entities.Entreprise;
import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo6 {
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Démo Many to One

        Transaction transaction = session.getTransaction();
        transaction.begin();

        // Création d'un entreprise
      /*  Entreprise entreprise = new Entreprise();
        entreprise.setNom("utopios");

        session.save(entreprise);

        Personne personne = new Personne();
        personne.setNom("Toto");
        personne.setPrenom("Titi");
        personne.setAge(30);
        personne.setEntreprise(entreprise);

        session.save(personne);

        transaction.commit();

        // Recuperation des personnes
        Query<Personne> personneQuery = session.createQuery("from Personne");
        List<Personne> personnes = personneQuery.list();
        for (Personne p: personnes) {
            //En lazy c'est uniquement au moment de la récuperation de l'entreprise qu'on recupere les informations
            Entreprise e = p.getEntreprise();
            if(e != null) {
                System.out.println(e.getNom());
            }
        }*/

        Entreprise entreprise = session.get(Entreprise.class,1);

        Personne personne = new Personne();
        personne.setNom("Tata");
        personne.setPrenom("Clément");
        personne.setEntreprise(entreprise);
        session.save(personne);
        entreprise.ajouterPersonne(personne);
        session.update(entreprise);

        transaction.commit();
        //Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();
    }
}
