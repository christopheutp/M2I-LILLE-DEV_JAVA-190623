package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Demo5 {
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Native SQL
        NativeQuery query = session.createSQLQuery("select * from Personne");
        List personnes = query.list(); // Le resultat est une liste de tableau objet non typé

        for (Object o: personnes) {
            Object[] p = (Object[]) o;
            System.out.println(p[0] + " "+p[1]+" "+p[2]);
        }


        //Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();
    }
}
