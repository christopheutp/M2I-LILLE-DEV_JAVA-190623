package org.example.impl;

import org.example.model.Category;
import org.example.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAOImpl {
    
        private EntityManagerFactory entityManagerFactory;

        public CategoryDAOImpl(EntityManagerFactory entityManagerFactory) {
            this.entityManagerFactory = entityManagerFactory;
        }

        public List<Task> getTasksByCategory(Category category) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            String jpql = "SELECT t FROM Task t JOIN t.categories c WHERE c = :category";
            TypedQuery<Task> query = entityManager.createQuery(jpql, Task.class);
            query.setParameter("category", category);
            List<Task> tasks = query.getResultList();
            entityManager.close();
            return tasks;
        }

        public void addTaskToCategory(Task task, Category category) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            task.getCategories().add(category);
            entityManager.merge(task);
            entityManager.getTransaction().commit();
            entityManager.close();
        }

        public void removeTaskFromCategory(Task task, Category category) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            task.getCategories().removeIf(category1 -> (category1.getName().equals(category.getName())));
            entityManager.merge(task);
            entityManager.getTransaction().commit();
            entityManager.close();
        }

        public List<Category> getAllCategories() {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            String jpql = "SELECT c FROM Category c";
            TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
            List<Category> categories = query.getResultList();
            entityManager.close();
            return categories;
        }

        public void addCategory(Category category) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(category);
            entityManager.getTransaction().commit();
            entityManager.close();
        }

        public void deleteCategory(Category category) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            category = entityManager.merge(category);
            entityManager.remove(category);
            entityManager.getTransaction().commit();
            entityManager.close();
        }

    public void deleteCategoryById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
        transaction.commit();
        entityManager.close();
    }

    public String getCategoryName(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
      //  EntityTransaction transaction = entityManager.getTransaction();
            String nameCategory = entityManager.find(Category.class,id).getName();
        entityManager.close();
            return nameCategory;
    }
    public Category getCategoryById(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
      //  EntityTransaction transaction = entityManager.getTransaction();
        Category category = entityManager.find(Category.class,id);
        entityManager.close();
        return category;
    }

}



