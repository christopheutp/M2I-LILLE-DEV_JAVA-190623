package org.example.dao;

import org.example.model.Category;
import org.example.model.Task;

import java.util.List;

public interface CategoryDAO {

    void addCategory(Category category);
    void deleteCategory(Category category);
    List<Task> getTasksByCategory(Category category);
    void addTaskToCategory(Task task, Category category);
    void removeTaskFromCategory(Task task, Category category);
    List<Category> getAllCategories();
    String getCategoryName(Long id);

    Category getCategoryById(Long id);


}
