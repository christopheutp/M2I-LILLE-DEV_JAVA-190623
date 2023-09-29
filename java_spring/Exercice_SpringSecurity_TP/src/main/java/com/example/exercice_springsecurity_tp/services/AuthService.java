package com.example.exercice_springsecurity_tp.services;

import com.example.exercice_springsecurity_tp.entities.RoleEntity;
import com.example.exercice_springsecurity_tp.entities.UserEntity;
import com.example.exercice_springsecurity_tp.models.AuthenticationRequest;
import com.example.exercice_springsecurity_tp.repositories.RoleEntityRepository;
import com.example.exercice_springsecurity_tp.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserEntityRepository userEntityRepository;
    private final RoleEntityRepository roleEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public void login(AuthenticationRequest authenticationRequest) {
        Optional<UserEntity> foundUser = userEntityRepository.findByEmail(authenticationRequest.getEmail());

        if (foundUser.isPresent()) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()
            );

            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
    }

    public void register(AuthenticationRequest authenticationRequest) {
        Optional<UserEntity> foundUser = userEntityRepository.findByEmail(authenticationRequest.getEmail());

        if (foundUser.isEmpty()) {
            UserEntity newUser = new UserEntity();
            newUser.setEmail(authenticationRequest.getEmail());
            newUser.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
            newUser.setFirstname(authenticationRequest.getFirstname().orElse(null));
            newUser.setLastname(authenticationRequest.getLastname().orElse(null));

            if (roleEntityRepository.findByName("USER").isEmpty()) {
                RoleEntity userRole = new RoleEntity();
                userRole.setName("USER");
                roleEntityRepository.save(userRole);
            }

            newUser.setRoles(Collections.singleton(roleEntityRepository.findByName("USER").orElse(null)));

            userEntityRepository.save(newUser);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()
            );

            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
    }
}
