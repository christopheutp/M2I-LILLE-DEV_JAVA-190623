package com.example.demo_springmvc_security_jwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/private")
public class PrivateRestController {
    @GetMapping
    public String getHello() {
        return "Hello world from the private endpoint!";
    }
}
