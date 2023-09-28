package com.example.demo_springmvc_security_jwt.services;

import com.example.demo_springmvc_security_jwt.components.JwtTokenGenerator;
import com.example.demo_springmvc_security_jwt.entities.UserEntity;
import com.example.demo_springmvc_security_jwt.models.AuthenticationRequest;
import com.example.demo_springmvc_security_jwt.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserEntityRepository userEntityRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenGenerator tokenGenerator;

    public String register(AuthenticationRequest request) {
        if (!userEntityRepository.existsByEmail(request.getEmail())) {
            UserEntity newUser = new UserEntity();
            newUser.setEmail(request.getEmail());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));

            userEntityRepository.save(newUser);
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenGenerator.generateToken(authentication);
    }

    public String authenticate(AuthenticationRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenGenerator.generateToken(authentication);
    }
}
