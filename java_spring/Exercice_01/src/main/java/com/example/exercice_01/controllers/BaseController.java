package com.example.exercice_01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/base") // http://localhost:8080/base
public class BaseController {

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping("1-param") // GET http://localhost:8080/base/1-param
    public String get1Param(Model model) {
        model.addAttribute("paramA", "John DUPONT");

        return "1-param";
    }

    @GetMapping("2-params") // GET http://localhost:8080/base/2-params
    public String get2Params(Model model) {
        model.addAttribute("paramA", "John DUPONT");
        model.addAttribute("paramB", "Maria SMITH");

        return "2-params";
    }

    @GetMapping("coll-params") // GET http://localhost:8080/base/coll-params
    public String getCollParams(Model model) {
        model.addAttribute("params", new ArrayList<String>());
        // model.addAttribute("params", List.of("John DUPONT", "Maria SMITH", "Chloée MARTEZ"));

        return "dossier/coll-params";
    }
}
