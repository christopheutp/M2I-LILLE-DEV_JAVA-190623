package org.example.demo;

import org.example.entity.Person;

import javax.persistence.*;
import java.util.List;

public class Demo2 {
    public static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transac = em.getTransaction();


        // Création d'une personne
        /*
        transac.begin();

        Person person = new Person("Tutu","titi");
        em.persist(person);
        System.out.println(person.getId());
        transac.commit();
        */


        // Récuperation de personne avec find et getReference
/*
        Person person1 = em.find(Person.class,5L);
        System.out.println(person1);

        Person person2 = em.getReference(Person.class,5L);
        System.out.println(person2);
*/

        // Récupération avec Query
        // createQuery single result
        /*
        Query query = em.createQuery("select p from Person p where p.nom = 'Tutu'");
        Person person3 = (Person) query.getSingleResult();
        System.out.println(person3);

         */


        // createQuery result list
        /*
        System.out.println("liste de personne avec id supérieur à 2");
        Query query1 =em.createQuery("select p from Person p where p.id > 2");
        List<Person> personList = query1.getResultList();
        for (Person p : personList){
            System.out.println(p);
        }

         */

        // Parametres nommés
        /*
        System.out.println("Liste de personne ave id supérieur à parametre nommées");
        Query query2 = em.createQuery("select p from Person p where p.id > :id ");
        query2.setParameter("id",4L);
        List<Person> personList1 = query2.getResultList();
        for (Person p : personList1){
            System.out.println(p);
        }

         */

        // Modification
        /*
        System.out.println("Modifier une occurence");
        transac.begin();
        Person person4 = em.find(Person.class,4L);
        System.out.println(person4);
        person4.setNom("Dupont");
        person4.setPrenom("Tintin");
        em.flush();
        transac.commit();
        person4 = em.find(Person.class,4L);
        System.out.println(person4);

         */

        // Suppression

        System.out.println("Suppression d'une occurence (personne avec l'id 5");
        transac.begin();
        Person person5 = em.find(Person.class,5L);
        em.remove(person5);
        transac.commit();
        Query query3 = em.createQuery("select p from Person p where p.id between 1 and 7");
        List<Person> personList2 = query3.getResultList();
        for (Person p : personList2){
            System.out.println(p);
        }
        // Fermeture
        em.close();
        emf.close();



    }
}
