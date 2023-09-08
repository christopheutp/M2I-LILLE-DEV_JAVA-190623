package com.example.exercice05.servlets;

import com.example.exercice05.data.FakeDB;
import com.example.exercice05.models.User;
import com.example.exercice05.models.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "signUpServlet", value = "/auth/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO dto = new UserDTO();
        ArrayList<String> errors = new ArrayList<>();

        req.setAttribute("user", dto);
        req.setAttribute("errors", errors);
        req.setAttribute("mode", "signUp");

        req.getRequestDispatcher("/WEB-INF/auth/signForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> errors = new ArrayList<>();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");

        Optional<User> foundUser = FakeDB.users.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst();

        if (!foundUser.isPresent()) {
            User newUser = new User(firstname, lastname, email, password);
            FakeDB.users.add(newUser);
            req.getSession().setAttribute("user", newUser);
            resp.sendRedirect(req.getContextPath() + "/private/profile");
        } else {
            errors.add("User already exists!");
            UserDTO dto = new UserDTO();
            dto.setEmail(email);
            dto.setPassword(password);
            dto.setFirstname(firstname);
            dto.setLastname(lastname);
            req.setAttribute("user", dto);
            req.setAttribute("errors", errors);
            req.setAttribute("mode", "signUp");
            req.getRequestDispatcher("/WEB-INF/auth/signForm.jsp").forward(req, resp);
        }
    }
}
