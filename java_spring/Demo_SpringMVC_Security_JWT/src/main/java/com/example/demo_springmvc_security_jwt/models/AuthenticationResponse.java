package com.example.demo_springmvc_security_jwt.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;
    private String type = "JWT";
}
