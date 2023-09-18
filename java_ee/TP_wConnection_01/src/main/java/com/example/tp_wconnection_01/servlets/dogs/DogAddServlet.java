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

@WebServlet(name = "dogAddServlet", value = "/dogs/add")
public class DogAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User activeUser = (User) req.getSession().getAttribute("activeUser");

        if (activeUser == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/signIn");
        } else {
            req.setAttribute("dog", new DogDTO());
            req.setAttribute("mode", 1);

            req.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User activeUser = (User) req.getSession().getAttribute("activeUser");

        if (activeUser == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/signIn");
        } else {
            Dog newDog = new Dog(
                    req.getParameter("name"),
                    req.getParameter("breed"),
                    LocalDate.parse(req.getParameter("dateOfBirth"))
            );

            activeUser.getDogs().add(newDog);

            resp.sendRedirect(req.getContextPath() + "/dogs/list");
        }

    }
}
