package org.example.demo;

import org.example.entity.manyToMany.Post;
import org.example.entity.manyToMany.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo5 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Post post = new Post("les dates en JAVA !!!!");
        Post post1 = new Post("les dates en JAVA moi j'adore");

        Tag tag = new Tag();
        tag.setName("Java");
        Tag tag1 = new Tag();
        tag1.setName("PHP");

        post.addTag(tag);
        post1.addTag(tag1);
        post.addTag(tag1);

        em.persist(post);
        em.persist(post1);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
