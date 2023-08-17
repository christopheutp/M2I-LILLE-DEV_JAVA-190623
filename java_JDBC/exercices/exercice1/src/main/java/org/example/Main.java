package org.example;


import org.example.utils.DatabaseManager;
import org.example.utils.IHM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Merci de saisir la date  : ");
        String dateString = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
           // date = new Date("01/01/2001");
            date = new Date();
        }
        System.out.println(new java.sql.Date(date.getTime()));

         */
        /*
        try {
            Connection connection = DatabaseManager.getPostgreSQLConnection();
            if(connection != null){
                System.out.println("La connexion est ok");
            }else {
                System.out.println("connexion echoué");
            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }

         */
        new IHM().start();
    }
}