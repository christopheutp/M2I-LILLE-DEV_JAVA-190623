package com.example.demo_springmvc_security_httpbasic.services;

import com.example.demo_springmvc_security_httpbasic.entities.UserEntity;
import com.example.demo_springmvc_security_httpbasic.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserEntityRepository userEntityRepository;
    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find a user with this email!"));
    }
}
