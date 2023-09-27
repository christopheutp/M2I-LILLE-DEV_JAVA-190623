package com.example.exospringsecurity01.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
@RequiredArgsConstructor
public class PrivateController {
    @GetMapping
    public String getHomeSecrets() {
        return "private/home";
    }

    @GetMapping("contacts")
    public String getContacts() {
        return "private/contacts";
    }

    @GetMapping("infos")
    public String getWebInfos() {
        return "private/infos";
    }
}
