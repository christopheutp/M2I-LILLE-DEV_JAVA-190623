package com.example.exercice03;

import com.example.exercice03.models.Cat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addCatServlet", value = "/cats/add")
public class AddCatServlet extends HttpServlet {
    private List<Cat> cats;

    @Override
    public void init() throws ServletException {
        cats = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();

        req.setAttribute("name", "");
        req.setAttribute("breed", "");
        req.setAttribute("favMeal", "");
        req.setAttribute("dateOfBirth", LocalDate.now().toString());
        req.setAttribute("errors", errors);
        req.setAttribute("confirmation", false);
        req.setAttribute("cats", cats);

        getServletContext().getRequestDispatcher("/WEB-INF/cats/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String favMeal = req.getParameter("favMeal");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        req.setAttribute("confirmation", false);

        if (favMeal.toUpperCase().equals("MILK")) {
            errors.add("Cats don't drink milk!");
        } else {
            Cat newCat = new Cat(name, breed, favMeal, dateOfBirth);
            cats.add(newCat);
            req.setAttribute("confirmation", true);
            System.out.println(newCat);
        }

        req.setAttribute("name", name);
        req.setAttribute("breed", breed);
        req.setAttribute("favMeal", favMeal);
        req.setAttribute("dateOfBirth", dateOfBirth.toString());
        req.setAttribute("errors", errors);
        req.setAttribute("cats", cats);

        getServletContext().getRequestDispatcher("/WEB-INF/cats/add.jsp").forward(req, resp);
    }
}
