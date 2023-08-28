package org.example;

import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
/*
        // Fonctions d'aggrégation
        Query<Integer> queryMaxAge = session.createQuery("select max(age) from Personne");
        int maxAge = queryMaxAge.uniqueResult();

        System.out.println(maxAge);

        double ageMoyen = (double)session.createQuery("select avg(age) from Personne").uniqueResult();
        System.out.println("Age moyen : "+ageMoyen);

        // Utilisation de la clause IN
        List noms = new ArrayList<String>();
        noms.add("tutu");
        noms.add("tata");

        Query<Personne> query = session.createQuery("from Personne where nom in :noms");
        query.setParameterList("noms",noms);

        List<Personne> personnes = query.list();

        for (Personne p: personnes) {
            System.out.println(p.getNom());
        }

 */

        // Utilisation de l'execute update ou le execute delete on utilise des transaction

        String update_query = "update Personne set nom = :nomP where id=2";
        Query query = session.createQuery(update_query);
        query.setParameter("nomP","Sirina");
        session.getTransaction().begin();
        int success = query.executeUpdate(); // C'est le nombre de ligne affectée par la requete
        session.getTransaction().commit();
        System.out.println(success);



        //Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();

    }
}
