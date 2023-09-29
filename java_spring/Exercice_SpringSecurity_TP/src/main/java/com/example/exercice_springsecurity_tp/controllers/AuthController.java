package com.example.exercice_springsecurity_tp.controllers;

import com.example.exercice_springsecurity_tp.models.AuthenticationRequest;
import com.example.exercice_springsecurity_tp.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("register")
    public String getRegisterForm(Model model) {
        model.addAttribute("authRequest", AuthenticationRequest.builder().build());
        model.addAttribute("mode", "register");

        return "auth/authForm";

    }

    @GetMapping("authenticate")
    public String getAuthenticationForm(Model model) {
        model.addAttribute("authRequest", AuthenticationRequest.builder().build());
        model.addAttribute("mode", "authenticate");

        return "auth/authForm";

    }

    @PostMapping("register")
    public String registerHandler(HttpServletRequest request, Model model, AuthenticationRequest authRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "auth/authForm";
        }

        authService.register(authRequest);

        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        return "redirect:/dogs";

    }

    @PostMapping("authenticate")
    public String authenticateHandler(HttpServletRequest request, Model model, AuthenticationRequest authRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "auth/authForm";
        }

        authService.login(authRequest);

        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        return "redirect:/dogs";

    }
}
