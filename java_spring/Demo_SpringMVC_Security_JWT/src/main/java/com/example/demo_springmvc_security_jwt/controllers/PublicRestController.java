package com.example.demo_springmvc_security_jwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/public")
public class PublicRestController {
    @GetMapping
    public String getHello() {
        return "Hello world from the public endpoint!";
    }
}
