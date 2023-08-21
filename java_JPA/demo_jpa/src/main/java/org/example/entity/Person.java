package org.example.entity;


import javax.persistence.*;

// Annotation @Entity indique que la classe est une enité
@Entity
// Annotation @Table optionnelle par défaut nom de la classe
@Table(name = "person")
public class Person {

    // Annotation @Id pour indiquer la clé primaire de la BDD
    @Id
    // spécifier la géneration automatique des valeurs d'une propriété identifiée comme clé primaire ou clé unique
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) // Utilisation de séquences (Oracle, PostgreSQL, etc.)
    //@GeneratedValue(strategy = GenerationType.TABLE)   // Utilisation d'une table de génération de clés
    //@GeneratedValue(strategy = GenerationType.AUTO)    // Sélection automatique de la meilleure stratégie
    //@GeneratedValue(strategy = GenerationType.NONE)    // Pas de génération automatique, valeurs fournies manuellement
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération basée sur auto-incrémentation (utilisé dans MySQL, PostgreSQL, etc.)
    private Long id;

    // Annotation @Basic facultative car JPA mappe les propriétés par défaut
    @Basic
    // Annotation Column optionnelle par défaut nom de l'attribut
    @Column(name = "name")
    private String nom;

    private String prenom;

    // Annotation @Transcient permet de ne pas tenir compte du champ lors du mapping
    @Transient
    private int age;

    // Constructeurs, getters et setters

    public Person() {
    }

    public Person(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }



}
