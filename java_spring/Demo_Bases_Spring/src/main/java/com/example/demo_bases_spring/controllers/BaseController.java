package com.example.demo_bases_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping(value = "/home")
    public String homePage() {
        return "home";
    }
}
