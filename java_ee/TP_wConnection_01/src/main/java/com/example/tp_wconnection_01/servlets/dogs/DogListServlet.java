package com.example.tp_wconnection_01.servlets.dogs;

import com.example.tp_wconnection_01.models.Dog;
import com.example.tp_wconnection_01.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "dogListServlet", value = "/dogs/list")
public class DogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User activeUser = (User) req.getSession().getAttribute("activeUser");

        if (activeUser == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/signIn");
        } else {
            List<Dog> dogs = activeUser.getDogs();

            req.setAttribute("dogs", dogs);

            req.getRequestDispatcher("/WEB-INF/dogs/list.jsp").forward(req, resp);
        }
    }
}
