package com.animalrenting.controllers;

import com.animalrenting.models.dtos.AuthenticationRequestPayload;
import com.animalrenting.models.dtos.AuthenticationResponsePayload;
import com.animalrenting.services.AnimalUserDetailsService;
import com.animalrenting.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponsePayload> createAuthenticationToken(
            @RequestBody AuthenticationRequestPayload payload
    ) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword())
            );
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw new RuntimeException("Error authenticating!");
        }

        final String jwt = jwtTokenUtil.generateToken(payload.getUsername());

        return ResponseEntity.ok(new AuthenticationResponsePayload(jwt));
    }
}
