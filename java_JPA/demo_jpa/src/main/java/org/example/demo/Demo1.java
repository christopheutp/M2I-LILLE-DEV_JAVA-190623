package org.example.demo;

import org.example.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo1 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");


    public static void main() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person person = new Person("Delory","Christophe");
        System.out.println("ID de la personne avant persist : "+person.getId());
        em.persist(person);
        System.out.println("ID de la personne aprés persist : "+person.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
