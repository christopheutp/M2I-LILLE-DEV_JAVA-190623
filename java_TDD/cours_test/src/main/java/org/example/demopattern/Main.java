package org.example.demopattern;

public class Main {
    public static void main(String[] args) {
       /*Person person = new PersonBuilder().name("toto").build();
       Person person1 = new PersonBuilder().address("tata").build();
       new PersonBuilder().name("tt").address("tt").phone("sfddsf").build();*/
        Person person = Person.builder().name("tt").phone("").address("qssdqd").build();
    }
}
