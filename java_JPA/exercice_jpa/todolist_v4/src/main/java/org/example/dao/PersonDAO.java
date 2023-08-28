package org.example.dao;

import org.example.model.Person;

import java.util.List;

public interface PersonDAO {

    public void addPerson(Person person);

    public void deletePerson(Long id);

    public List<Person> getAllPersons();
}
