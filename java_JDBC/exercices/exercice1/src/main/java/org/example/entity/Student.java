package org.example.entity;

import org.example.utils.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateDegree;
    private int classNumber;

    private static String request;
    private static Connection connection;

    private static PreparedStatement statement;

    public Student(String firstName, String lastName, Date dateDegree, int classNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateDegree = dateDegree;
        this.classNumber = classNumber;
    }

    public Student(int id,String firstName, String lastName, Date dateDegree, int classNumber) {
        this(firstName, lastName, dateDegree, classNumber);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateDegree() {
        return dateDegree;
    }

    public void setDateDegree(Date dateDegree) {
        this.dateDegree = dateDegree;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateDegree=" + dateDegree +
                ", classNumber=" + classNumber +
                '}';
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO student (first_name, last_name, date_degree, class_number) VALUES ( ?,?,?,?)";
        connection = DatabaseManager.getPostgreSQLConnection();
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,getFirstName());
        statement.setString(2,getLastName());
        statement.setDate(3,new java.sql.Date(getDateDegree().getTime()));
        statement.setInt(4,getClassNumber());
        int nbRows = statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
           setId(resultSet.getInt(1));
        }
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return nbRows > 0;
    }

    public static List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        request ="SELECT * FROM student";
        connection = DatabaseManager.getPostgreSQLConnection();
        statement = connection.prepareStatement(request);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Student s = new Student(resultSet.getInt("id"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getDate("date_degree"),resultSet.getInt("class_number"));
            students.add(s);
        }
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return students;
    }

    public boolean delete() throws SQLException {
        request = "DELETE FROM student where id = ?";
        connection = DatabaseManager.getPostgreSQLConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1,getId());
        int nbRow = statement.executeUpdate();
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return nbRow > 0;
    }

    public static List<Student> getByClass(int classNumber) throws SQLException {
        List<Student> students = new ArrayList<>();
        request ="SELECT * FROM student where class_number = ?";
        connection = DatabaseManager.getPostgreSQLConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1,classNumber);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Student s = new Student(resultSet.getInt("id"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getDate("date_degree"),resultSet.getInt("class_number"));
            students.add(s);
        }
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return students;
    }




}
