package com.example.demo_spring_security_session.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/private")
@RequiredArgsConstructor
public class PrivateRestController {
    @GetMapping
    public String getPrivateSecrets(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        if (authorization != null && authorization.equals("johnny")) {
            return "This is my secret: I hate broccoli";
        }

        return "Status 403";

    }
}
