package com.appcellon.coronatracker.controllers;

import com.appcellon.coronatracker.services.DataService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        var allStats = DataService.getAllStats();
        int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestCaseTotal()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getPrevDayTotal()).sum();

        model.addAttribute("allStats", allStats);
        model.addAttribute("totalCases", totalCases);
        model.addAttribute("totalNewCases", totalNewCases);

        return "home";
    }

}
