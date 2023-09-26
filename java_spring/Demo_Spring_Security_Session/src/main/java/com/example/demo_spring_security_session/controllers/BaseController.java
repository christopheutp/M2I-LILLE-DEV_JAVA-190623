package com.example.demo_spring_security_session.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class BaseController {
    @GetMapping
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "johnny");

            return "redirect:/private";
        }

        return "redirect:/login";
    }

}
