package com.example.demo_bases_spring.controllers;

import com.example.demo_bases_spring.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    private final GreetingsService greetingsService;

    public HelloController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @RequestMapping(value = "/hello")
    public String sayHello() {
        System.out.println(greetingsService.sayHello());

        return "home";
    }
}
