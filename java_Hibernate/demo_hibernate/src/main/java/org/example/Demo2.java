package org.example;

import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


import java.util.Iterator;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // HQL

        // Récupérer la liste des personnes
        // le support utilise l'interface query au lieu de la classe générique query (l'interface est dépréciée)
        Query<Personne> personneQuery = session.createQuery("from Personne");

        // avec la liste
        List<Personne> personnes = personneQuery.list();
        for (Personne p: personnes) {
            System.out.println(p.getNom());
        }

        // avec l'iterator
        Iterator<Personne> personneIterator = personneQuery.iterate();
        while(personneIterator.hasNext()){
            Personne p = (Personne) personneIterator.next();
            System.out.println(p.getNom());
        }

        // Une requete avec filtre pour récupérer une liste
        Query<Personne> personneQuery1 = session.createQuery("from Personne where nom = 'toto' ");
        // Récupérer une liste avec les personnes dont le nom est toto
        List<Personne> personneList = personneQuery1.list();
        for (Personne p: personneList) {
            System.out.println(p.getNom());
        }

        //Une requete avec un filtre pour recuperer un seul element
        Query<Personne> personneQuery2 = session.createQuery("from Personne where id = 2");
        Personne p = personneQuery2.uniqueResult();
        System.out.println(p.getNom());

        //Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();
    }
}
