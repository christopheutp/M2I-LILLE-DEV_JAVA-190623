package com.example.demo_springmvc_security_httpbasic.services;

import com.example.demo_springmvc_security_httpbasic.entities.UserEntity;
import com.example.demo_springmvc_security_httpbasic.models.AuthenticationRequest;
import com.example.demo_springmvc_security_httpbasic.repositories.UserEntityRepository;
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

    public void register(AuthenticationRequest request) {
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




    }
}
