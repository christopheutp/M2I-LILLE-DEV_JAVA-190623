package com.example.demo_springmvc_security_httpbasic.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRequest {
    private String email;
    private String password;
}
