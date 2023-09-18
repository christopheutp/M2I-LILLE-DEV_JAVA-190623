package com.example.tp_wconnection_01.servlets.auth;

import com.example.tp_wconnection_01.data.FakeDB;
import com.example.tp_wconnection_01.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "signUpServlet", value = "/auth/signUp")
public class SignUpServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();

        req.setAttribute("email", "");
        req.setAttribute("password", "");
        req.setAttribute("errors", errors);

        req.getRequestDispatcher("/WEB-INF/auth/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> userFound = FakeDB.users.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst();

        if (userFound.isEmpty()) {
            User newUser = new User(email, password);
            FakeDB.users.add(newUser);
            req.getSession().setAttribute("activeUser", newUser);
            resp.sendRedirect(req.getContextPath() + "/dogs/list");
        } else {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            errors.add("User already exists!");
            req.setAttribute("errors", errors);

            req.getRequestDispatcher("/WEB-INF/auth/signUp.jsp").forward(req, resp);
        }
    }
}
