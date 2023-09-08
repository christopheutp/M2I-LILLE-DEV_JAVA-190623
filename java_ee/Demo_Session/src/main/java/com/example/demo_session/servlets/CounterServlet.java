package com.example.demo_session.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "counterServlet", value = "/counter")
public class CounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int countValue = 0;

        if (req.getSession().getAttribute("count") == null) {
            req.getSession().setAttribute("count", 1);
        } else {
            countValue = (int) req.getSession().getAttribute("count");
        }

        req.setAttribute("count", countValue);

        req.getRequestDispatcher("/WEB-INF/count.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int countValue = Integer.parseInt(req.getParameter("count"));
        int countValue = (int) req.getSession().getAttribute("count");

        System.out.println(req.getSession().getId());

        countValue++;

        req.getSession().setAttribute("count", countValue);

        req.setAttribute("count", countValue);

        req.getRequestDispatcher("/WEB-INF/count.jsp").forward(req, resp);
    }
}
