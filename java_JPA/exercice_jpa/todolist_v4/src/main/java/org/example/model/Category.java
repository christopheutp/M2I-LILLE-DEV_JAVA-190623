package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // attention erreur lazy si fetchtype pas défini sur EAGER
    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    private List<Task> tasks;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


}
