package org.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo5 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");
}
