package com.example.demo_connexion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "privateHelloServlet", value = "/private/hello")
public class PrivateHelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isConnected = (Boolean) (req.getSession().getAttribute("connected") != null ? req.getSession().getAttribute("connected") : false);

        if (isConnected) {
            req.getRequestDispatcher("/WEB-INF/private/hello.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/signIn");
        }
    }
}
