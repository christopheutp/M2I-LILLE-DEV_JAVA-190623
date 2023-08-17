package org.example.utils;

import org.example.entity.Student;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IHM {
    private Scanner scanner;
    public IHM(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        int choix;
        do{
            menu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix){
                case 1:
                    addStudent();
                    break;
                case 2:
                    getAllStudent();
                    break;
                case 3:
                    getAllStudentByClass();
                    break;
                case 4:
                    deleteStudent();
                    break;
            }

        }while (choix != 0);
    }

    private void menu(){
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Afficher la liste des étudiants");
        System.out.println("3. Afficher la liste des étudiants d'une classe");
        System.out.println("4. Supprimer un étudiant");
    }

    public void addStudent(){
        System.out.println("*** Ajouter un étudiant ***");
        System.out.println("Merci de saisir le nom :");
        String lastName = scanner.nextLine();
        System.out.println("Merci de saisir le prenom :");
        String firstName = scanner.nextLine();
        System.out.println("Merci de saisir la date du diplome : (format jour-mois-année)");
        String dateDegreeString = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateDegree = null;
        try {
            dateDegree = dateFormat.parse(dateDegreeString);
        } catch (ParseException e) {
            dateDegree = new Date();
        }
        System.out.println("Merci de saisir la classe :");
        int classNumber = scanner.nextInt();
        scanner.nextLine();
        Student student = new Student(firstName,lastName,dateDegree,classNumber);
        try {
            if(student.save()){
                System.out.println(" Etudiant ajouté avec id : "+student.getId());
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteStudent(){
        System.out.println("Merci de saisir l'id de l'étudiant : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Student student = Student.getById(id);
            if(student.delete()){
                System.out.println("Etudiant supprimé");
            };
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllStudent(){
        try{
            Student.getAll().forEach(s -> System.out.println(s));
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllStudentByClass(){
        try{
            System.out.println("Merci de saisir la classe :");
            int classNumber = scanner.nextInt();
            scanner.nextLine();
            Student.getByClass(classNumber).forEach(s -> System.out.println(s));
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
