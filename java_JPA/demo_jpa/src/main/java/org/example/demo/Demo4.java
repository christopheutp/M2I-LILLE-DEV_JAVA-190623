package org.example.demo;

import org.example.entity.oneToMany.Department;
import org.example.entity.oneToMany.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;

public class Demo4 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo_postgres");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setId(6);
        Employee employee1 = new Employee();
        employee1.setId(8);

        Department department = new Department();
        department.setId(1);
        department.setDname("Science");

        employee.setD(department);
        employee1.setD(department);

        Collection<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);

        department.setEmps(list);

        em.persist(department);
        em.persist(employee);
        em.persist(employee1);

        em.getTransaction().commit();

    }
}
