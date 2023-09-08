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
import java.util.Optional;

@WebServlet(name = "dogDetailsServlet", value = "/dogs/details/*")
public class DogDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long dogId = Long.parseLong(req.getPathInfo().substring(1));

        Optional<Dog> dogFound = FakeDB.dogs.stream().filter(d -> d.getId() == dogId).findFirst();

        if(dogFound.isPresent()) {
            DogDTO dogDetails = new DogDTO(
                    dogFound.get().getId(),
                    dogFound.get().getName(),
                    dogFound.get().getBreed(),
                    dogFound.get().getBirthDate().toString(),
                    dogFound.get().getSterilized().toString()
            );

            req.setAttribute("dog", dogDetails);
            req.setAttribute("mode", "view");

            req.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/dogs/list");
        }

    }
}
