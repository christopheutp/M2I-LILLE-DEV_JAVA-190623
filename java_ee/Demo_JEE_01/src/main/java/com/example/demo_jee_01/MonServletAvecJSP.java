package com.example.demo_jee_01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "monServletAvecJSP", value = "/monservlet-jsp")
public class MonServletAvecJSP extends HttpServlet {

    private String prenom;
    private List<String> prenoms;
    @Override
    public void init() throws ServletException {
        prenom = "Johnny";

        prenoms = new ArrayList<>();
        prenoms.add("Jack");
        prenoms.add("Sully");
        prenoms.add("Chloée");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("blabla", prenom);
        req.setAttribute("prenomB", prenom);
        req.setAttribute("prenoms", prenoms);

        getServletContext().getRequestDispatcher("/test-01.jsp").forward(req, resp);
    }
}
