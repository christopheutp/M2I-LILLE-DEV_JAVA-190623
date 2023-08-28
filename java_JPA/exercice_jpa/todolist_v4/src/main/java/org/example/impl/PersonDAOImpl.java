package org.example.impl;

import org.example.dao.PersonDAO;
import org.example.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private EntityManagerFactory entityManagerFactory;

    public PersonDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void addPerson(Person person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(person);
        transaction.commit();
        entityManager.close();

    }

    @Override
    public void deletePerson(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Person person = entityManager.find(Person.class, id);
        if(person != null){
            entityManager.remove(person);
        }
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<Person> getAllPersons() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Person> persons = entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        entityManager.close();
        return persons;
    }
}
