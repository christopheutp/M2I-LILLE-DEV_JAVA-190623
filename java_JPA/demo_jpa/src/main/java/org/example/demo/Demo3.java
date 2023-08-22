package org.example.demo;

import org.example.entity.oneToOne.Adress;
import org.example.entity.oneToOne.House;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo3 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");
    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Adress adress = new Adress();
        adress.setNumero(46);
        adress.setNomRue("rue des pias");
        adress.setCodePostal("59000");
        adress.setVille("Lille");


        House house = new House();

        house.setTaille(432);
        house.setAdress(adress);
        em.persist(house);

        em.getTransaction().commit();
        House housesearch = em.find(House.class, house.getId());
        System.out.println(housesearch);

        em.close();
        emf.close();
    }
}
