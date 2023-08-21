package org.example.demo;

import org.example.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo1 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");


    public static void main() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person person = new Person("toto","tata");
        System.out.println("ID de la personne avant persist : "+person.getId());
        em.persist(person);
        System.out.println("ID de la personne aprés persist : "+person.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    public static void main2(){
        EntityManager em = emf.createEntityManager();

        Person person = em.find(Person.class, 42L);
        System.out.println(person.toString());
        em.close();
        emf.close();

    }

    public static void main3(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, 2L);
        System.out.println(person.toString());
        person.setNom("tutu");
        System.out.println(person.toString());
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    public static void remove(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = em.find(Person.class, 1L);
        em.remove(person);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void createQuery(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person("Delory","Christophe");
        Person person1 = new Person("Toto","Tata");

        em.persist(person);
        em.persist(person1);

        List<Person> personList = null;

        personList = em.createQuery("select p from Person p", Person.class).getResultList();

        for (Person p:personList){
            System.out.println(p);
        }

        em.getTransaction().commit();

    }

}
