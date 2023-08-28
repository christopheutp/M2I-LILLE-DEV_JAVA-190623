package org.example.controller;

import org.example.impl.CategoryDAOImpl;
import org.example.impl.PersonDAOImpl;
import org.example.impl.TaskDAOImpl;
import org.example.model.Category;
import org.example.model.Person;
import org.example.model.Task;
import org.example.model.TaskInfo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ToDoListAppConsole {

    private static EntityManagerFactory entityManagerFactory;
    private static TaskDAOImpl taskDAO;
    private static PersonDAOImpl personDAO;
    private static CategoryDAOImpl categoryDAO;

    public static void main() {
        entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
        taskDAO = new TaskDAOImpl(entityManagerFactory);
        personDAO = new PersonDAOImpl(entityManagerFactory);
        categoryDAO = new CategoryDAOImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("=== ToDo List Manager ===");
            System.out.println("1. Ajouter une personne");
            System.out.println("2. Afficher les tâches d'une personne");
            System.out.println("3. Ajouter une tâche");
            System.out.println("4. Afficher toutes les tâches");
            System.out.println("5. Marquer une tâche comme terminée");
            System.out.println("6. Supprimer une personne et ses tâches associées");
            System.out.println("7. Supprimer une tâche");
            System.out.println("8. Ajouter une catégorie");
            System.out.println("9. Supprimer une catégorie");
            System.out.println("10. Afficher les tâches d'une catégorie");
            System.out.println("11. Ajouter une taches à une catégorie");
            System.out.println("12. Supprimer une taches à une catégorie");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choice) {
                case 1:
                    addPerson(scanner);
                    break;
                case 2:
                    displayTasksPerson(scanner);
                    break;
                case 3:
                    addTask(scanner);
                    break;
                case 4:
                    displayTasks();
                    break;
                case 5:
                    markTaskAsCompleted(scanner);
                    break;
                case 6:
                    deleteUser(scanner);
                    break;
                case 7:
                    deleteTask(scanner);
                    break;
                case 8:
                    addCategory(scanner);
                    break;
                case 9:
                    deleteCategory(scanner);
                    break;
                case 10:
                    showTasksCategory(scanner);
                    break;
                case 11:
                    addCategoryToTask(scanner);
                    break;
                case 12:
                    deleteCategoryToTask(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choice != 0);

        entityManagerFactory.close();
    }

    private static void addTask(Scanner scanner){
        System.out.println("Entrer le titre de la tâche : ");
        String title = scanner.nextLine();

        System.out.println("Entrer la description de la tâche : ");
        String description = scanner.nextLine();

        System.out.println("Date limite de la tâche : (dd.MM.yyyy)");
        String dueDateStr = scanner.nextLine();

        LocalDate dueDate = LocalDate.parse(dueDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Priorité de la tâche : ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entrez l'ID de la personne pour cette tâche : ");
        Long personId = scanner.nextLong();

        // Creation de la tache
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);

        //Creation de la taskinfo
        TaskInfo taskInfo = new TaskInfo(description,dueDate,priority);

        // Mise en relation
        task.setTaskInfo(taskInfo);
        taskInfo.setTask(task);

        if(taskDAO.addTask(task,personId)){
            System.out.println("Tâche ajoutée avec succès !");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void displayTasks() {
        List<Task> tasks = taskDAO.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée.");
        } else {
            System.out.println("=== Liste des tâches ===");
            for (Task task : tasks) {
                System.out.println("###########");
                System.out.println(task.getId() + ". " + task.getTitle() + " (" + (task.isCompleted() ? "Terminée" : "En cours") + ")");
                System.out.println(task.getTaskInfo().toString());
                System.out.println("###########");
            }
        }
    }

    private static void deleteTask(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.deleteTask(taskId)){
            System.out.println("Suppression OK");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche finie : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.markTaskAsCompleted(taskId)){
            System.out.println("Modification OK");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void addPerson(Scanner scanner){
        System.out.println("Entrer le nom de la personne : ");
        String personName = scanner.nextLine();

        Person person = new Person(personName);
        personDAO.addPerson(person);
        System.out.println("Personne ajoutée");
    }

    private static void displayTasksPerson(Scanner scanner){
        System.out.println("Entrez l'ID de la personne  : ");
        Long personId  = scanner.nextLong();
        scanner.nextLine();

        List<Task> tasks = taskDAO.gettasksByPersonId(personId);
        System.out.println("Tâches de la personne avec l' ID : "+ personId + " : ");
        for (Task t : tasks){
            System.out.println("- "+ t.getPerson().getName()+ " " + t.getTitle()+ " "+ t.getTaskInfo().toString() + (t.isCompleted() ? " (Terminée)" : "(en cours)"));
        }
    }

    private static void deleteUser(Scanner scanner){
        System.out.println("Entrez l'ID de la personne à supprimer : ");
        Long personId  = scanner.nextLong();
        scanner.nextLine();
        personDAO.deletePerson(personId);
        System.out.println("Personne supprimée");

    }

    private static void addCategory(Scanner scanner){
        System.out.println("Entrez le nom de la catégorie :");
        String categoryName = scanner.nextLine();

        Category category = new Category(categoryName);
        categoryDAO.addCategory(category);
        System.out.println("Catégorie ajoutée avec succès !");

    }

    private static void deleteCategory(Scanner scanner){
        System.out.println("Entrez l'ID de la catégorie à supprimer :");
        Long categoryIdToDelete = scanner.nextLong();

        categoryDAO.deleteCategoryById(categoryIdToDelete);
        System.out.println("Catégorie esupprimée avec succès !");

    }

    private static void showTasksCategory(Scanner scanner){
        System.out.println("Entrez l'ID de la catégorie pour afficher ses tâches :");
        Long categoryId = scanner.nextLong();
        String nameCategory = categoryDAO.getCategoryName(categoryId);
        Category category = categoryDAO.getCategoryById(categoryId);
        List<Task> tasks = categoryDAO.getTasksByCategory(category);
        System.out.println("Tâches de la catégorie : "+ nameCategory +" avec l'ID " + categoryId + ":");
        for (Task t : tasks) {
            System.out.println("- "+ t.getPerson().getName()+ " " + t.getTitle()+ " "+ t.getTaskInfo().toString() + (t.isCompleted() ? " (Terminée)" : "(en cours)"));
        }

    }

    private static void addCategoryToTask(Scanner scanner){
        System.out.print("Entrez l'ID de la tâche  : ");
        Long taskId = scanner.nextLong();
        scanner.nextLine(); // Consomme la nouvelle ligne
        System.out.print("Entrez l'ID de la catégorie  : ");
        Long categoryId = scanner.nextLong();
        scanner.nextLine(); // Consomme la nouvelle ligne
        Category category = categoryDAO.getCategoryById(categoryId);
        System.out.println(category.getName());
        Task task = taskDAO.getTaskById(taskId);
        System.out.println(task.getTitle());
        categoryDAO.addTaskToCategory(task,category);

    }

    private static void deleteCategoryToTask(Scanner scanner){
        System.out.print("Entrez l'ID de la tâche  : ");
        Long taskId = scanner.nextLong();
        scanner.nextLine(); // Consomme la nouvelle ligne
        System.out.print("Entrez l'ID de la catégorie  : ");
        Long categoryId = scanner.nextLong();
        scanner.nextLine(); // Consomme la nouvelle ligne
        Category category = categoryDAO.getCategoryById(categoryId);
        Task task = taskDAO.getTaskById(taskId);
        categoryDAO.removeTaskFromCategory(task,category);
    }
}
