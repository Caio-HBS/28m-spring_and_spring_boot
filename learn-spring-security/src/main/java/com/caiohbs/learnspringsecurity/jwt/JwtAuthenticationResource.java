package com.caiohbs.learnspringsecurity.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationResource {

    @PostMapping(path="/authenticate")
    public Authentication authenticate(Authentication authentication) {
        return authentication;
    }

}
