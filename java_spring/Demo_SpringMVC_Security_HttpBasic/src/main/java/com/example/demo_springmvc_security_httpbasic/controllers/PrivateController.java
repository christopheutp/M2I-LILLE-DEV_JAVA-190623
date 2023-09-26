package com.example.demo_springmvc_security_httpbasic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
@RequiredArgsConstructor
public class PrivateController {
    @GetMapping
    public String getSecretPage() {
        return "private/home";
    }
}
