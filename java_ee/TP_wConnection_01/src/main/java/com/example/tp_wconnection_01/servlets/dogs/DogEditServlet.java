package com.example.tp_wconnection_01.servlets.dogs;

import com.example.tp_wconnection_01.models.Dog;
import com.example.tp_wconnection_01.models.DogDTO;
import com.example.tp_wconnection_01.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "dogEditServlet", value = "/dogs/edit/*")
public class DogEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User activeUser = (User) req.getSession().getAttribute("activeUser");

        if (activeUser == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/signIn");
        } else {
            Long dogId = Long.parseLong(req.getPathInfo().substring(1));

            List<Dog> dogs = activeUser.getDogs();

            Optional<Dog> foundDog = dogs.stream().filter(d -> d.getId().equals(dogId)).findFirst();

            if(foundDog.isPresent()) {
                DogDTO dogDTO = new DogDTO(
                        foundDog.get().getId(),
                        foundDog.get().getName(),
                        foundDog.get().getBreed(),
                        foundDog.get().getDateOfBirth().toString()
                );

                req.setAttribute("mode", 3);
                req.setAttribute("dog", dogDTO);

                req.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/dogs/list");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User activeUser = (User) req.getSession().getAttribute("activeUser");

        if (activeUser == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/signIn");
        } else {
            Long dogId = Long.parseLong(req.getParameter("id"));

            List<Dog> dogs = activeUser.getDogs();

            Optional<Dog> foundDog = dogs.stream().filter(d -> d.getId().equals(dogId)).findFirst();

            foundDog.ifPresent(dog -> {
                dog.setName(req.getParameter("name"));
                dog.setBreed(req.getParameter("breed"));
                dog.setDateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")));
            });

            resp.sendRedirect(req.getContextPath() + "/dogs/list");
        }
    }
}
