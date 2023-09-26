package com.example.demo_spring_security_session.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/private")
public class PrivateController {
    @GetMapping
    public String getPrivatePage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        if (user != null && user.equals("johnny")) {
            return "private/secrets";
        }

        return "redirect:/";
    }
}

