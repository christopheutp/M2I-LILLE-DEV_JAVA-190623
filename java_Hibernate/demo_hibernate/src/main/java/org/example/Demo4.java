package org.example;

import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Récuperation des elements avec des parametres dans le filtre
        String search = "t";

        // parametres avec des noms
        Query<Personne> personneQuery = session.createQuery("from Personne where nom like :nom");
        // dans le support ont utilise setString et setInteger elles sont deprecated
        personneQuery.setParameter("nom",search+"%", StringType.INSTANCE);
        List<Personne> personnes = personneQuery.list();

        // parametres avec des positions
        // il faut indiquer le numéro de paramentre en plus de ?
        Query<Personne> personneQuery1 = session.createQuery("from Personne where nom like ?1");
        personneQuery1.setParameter(1,search+"%",StringType.INSTANCE);
        List<Personne> personnes1 = personneQuery1.list();

        // Utiliser des alias comme en sql
        Query<Personne> personneQuery2 = session.createQuery("from Personne as p where p.nom like ?1");
        personneQuery2.setParameter(1,search+"%",StringType.INSTANCE);
        List<Personne> personnes2 = personneQuery2.list();


        for (Personne p :personnes) {
            System.out.println(p.getNom());
        }
        for (Personne p :personnes1) {
            System.out.println(p.getNom());
        }
        for (Personne p :personnes2) {
            System.out.println(p.getNom());
        }

        // Utiliser un select comme en SQL
        Query<Personne> personneQuery3 = session.createQuery("SELECT nom, prenom from Personne as p where p.nom like ?1");
        personneQuery3.setParameter(1,search+"%",StringType.INSTANCE);
        // Attention le resultat ne sera pas une arraylist d'objet de meme type mais un arraylist de tableau d'objet
        List result = personneQuery3.list();

        List<Personne> personneList = new ArrayList<>();

        // Convertir le resultat en list d'objet Personne
        for (Object o: result) {
            Object[] res = (Object[]) o;
            Personne pr = new Personne();
            pr.setNom((String) res[0]);
            pr.setPrenom((String) res[1]);
            personneList.add(pr);
        }

        for (Personne p :personneList) {
            System.out.println(p.getNom());
            System.out.println(p.getPrenom());
        }

        //Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();
    }
}
