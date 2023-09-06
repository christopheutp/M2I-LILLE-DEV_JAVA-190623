package com.example.exercice02.controllers;

import com.example.exercice02.models.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personServlet", value = "/person/list")
public class PersonServlet extends HttpServlet {
    private List<Person> persons;

    @Override
    public void init() throws ServletException {
        persons = new ArrayList<>();
        persons.add(new Person("John", "DUPONT", 47));
        persons.add(new Person("Maria", "DUPONT", 42));
        persons.add(new Person("Chloée", "DUPONT", 7));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("persons", persons);

        getServletContext().getRequestDispatcher("/WEB-INF/persons/list.jsp").forward(req, resp);
    }
}
