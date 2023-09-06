package com.example.demo_jee_01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "recapVariableServlet", value = "/variable")
public class RecapVariablesServlet extends HttpServlet {
    private int count;

    @Override
    public void init() throws ServletException {
        count = 1;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("number", count);
        req.setAttribute("numberBis", count);

        getServletContext().getRequestDispatcher("/WEB-INF/counter.jsp").forward(req, resp);

        count++;
    }
}
