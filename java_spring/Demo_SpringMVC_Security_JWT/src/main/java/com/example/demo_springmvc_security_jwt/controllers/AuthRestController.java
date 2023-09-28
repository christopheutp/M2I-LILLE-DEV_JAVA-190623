package com.example.demo_springmvc_security_jwt.controllers;

import com.example.demo_springmvc_security_jwt.models.AuthenticationRequest;
import com.example.demo_springmvc_security_jwt.models.AuthenticationResponse;
import com.example.demo_springmvc_security_jwt.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthRestController {
    private final AuthService authService;



    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> registerHandler(@RequestBody AuthenticationRequest formValues) {
        String token = authService.register(formValues);

        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(token)
                .build();

        return ResponseEntity.ok(response);
    }



    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateHandler(@RequestBody AuthenticationRequest formValues) {
        String token = authService.authenticate(formValues);

        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(token)
                .build();

        return ResponseEntity.ok(response);
    }
}
