package com.example.exercice04.controllers;

import com.example.exercice04.data.FakeDB;
import com.example.exercice04.models.Dog;
import com.example.exercice04.models.DogDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "dogAddServlet", value = "/dogs/add")
public class DogAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DogDTO dogToAdd = new DogDTO(0L, "", "", LocalDate.now().toString(), "false");

        req.setAttribute("dog", dogToAdd);
        req.setAttribute("mode", "add");

        req.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        Boolean isSterlized = Boolean.parseBoolean(req.getParameter("isSterilized"));

        Dog newDog = new Dog(
                name,
                breed,
                birthDate,
                isSterlized
        );

        FakeDB.dogs.add(newDog);

        // resp.sendRedirect(req.getContextPath() + "/dogs/list");
        resp.sendRedirect("list");
    }
}
