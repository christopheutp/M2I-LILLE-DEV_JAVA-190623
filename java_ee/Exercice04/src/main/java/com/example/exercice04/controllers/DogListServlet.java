package com.example.exercice04.controllers;

import com.example.exercice04.data.FakeDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.exercice04.models.Dog;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "dogListServlet", value = "/dogs/list")
public class DogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dogs", FakeDB.dogs);

        req.getRequestDispatcher("/WEB-INF/dogs/list.jsp").forward(req, resp);
    }
}
