package com.example.demo_springmvc_security_jwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {
    @Value("${jwt.secretKey}")
    private String secretKey;
    @GetMapping
    public String getHomePage() {


        return "home";
    }
}
