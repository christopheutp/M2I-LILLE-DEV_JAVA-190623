package com.example.demo_bases_spring.controllers;

import com.example.demo_bases_spring.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerSet {

    // Injection de dépendance par propriété

    // @Autowired
    // public GreetingsService greetingsService;

    // Injection de dépendance par setter

//    private GreetingsService greetingsService;
//
//    @Autowired
//    public void setGreetingsService( GreetingsService greetingsService) {
//        this.greetingsService = greetingsService;
//    }

    // Injection de dépendance par constructeur
    private final GreetingsService greetingsService;

    public HelloControllerSet(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @RequestMapping(value = "/hello-set")
    public String sayHello() {
        System.out.println(greetingsService.sayHello());

        return "home";
    }

}
