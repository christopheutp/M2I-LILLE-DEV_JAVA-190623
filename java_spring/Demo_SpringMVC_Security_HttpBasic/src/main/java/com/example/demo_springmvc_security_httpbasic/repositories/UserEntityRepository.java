package com.example.demo_springmvc_security_httpbasic.repositories;

import com.example.demo_springmvc_security_httpbasic.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
    Boolean existsByEmail(String email);
}
