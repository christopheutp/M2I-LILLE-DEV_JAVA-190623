package com.example.recap_spring_2023_09_22.controllers;

import com.example.recap_spring_2023_09_22.models.ContactDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
@Slf4j
public class HomeController {

    @GetMapping // GET http://localhost:8080/home
    public String getHomePage() {
        return "home";
    }

    @GetMapping("avec-param") // GET http://localhost:8080/home/avec-param OU GET http://localhost:8080/home/avec-param?paramA=sdqdqdqd
    public String getHomePageWithParam(Model model, @RequestParam(value = "paramA", defaultValue = "") String qqch) {
        model.addAttribute("testParam", "blabla");
        model.addAttribute("testSwitch", "D");
        model.addAttribute("testParams", List.of("John", "Maria", "Chloée"));
        model.addAttribute("contact", ContactDTO.builder().firstname("Johnny").lastname("SMITH").build());

        return "home-avec-param";
    }

    @GetMapping("/{nomQuonChoisi}")
    public String getParamPage(@PathVariable("nomQuonChoisi") String autreNom){


        return "redirect:/home/avec-param?paramA=" + autreNom;
    }

    @GetMapping("/add")
    public String getForm(Model model) {
        model.addAttribute("contact", ContactDTO.builder().build());

        return "home-add";
    }

    @PostMapping("/add")
    public String postHandler(@Valid ContactDTO contactDTO, BindingResult results) {
        if (results.hasErrors()) {
            results.getAllErrors().forEach(err -> log.error(err.toString()));

            return "home-add";
        }

        // Ajoute ma personne

        return "redirect:/home/avec-param";
    }


}
