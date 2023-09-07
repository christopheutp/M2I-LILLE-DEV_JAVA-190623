package com.example.demo_parameters;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "formServlet", value = "/form")
public class FormServlet extends HttpServlet {

    private String myInitParam;

    @Override
    public void init() throws ServletException {
        myInitParam = getServletContext().getInitParameter("blabla");
        System.out.println(myInitParam);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        req.setAttribute("mode", mode);
        getServletContext().getRequestDispatcher("/WEB-INF/addPerson.jsp").forward(req, resp);

        // int myNumber = 125 / 0;


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // localhost:8080/route/du/servlet?paramA="hole"&paramB="bibi"

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        Double age = Double.parseDouble(req.getParameter("age"));

        System.out.printf("firstname: %s, lastname = %s, age = %f", firstname, lastname, age);


    }
}
