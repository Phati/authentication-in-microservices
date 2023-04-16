package com.quizz.userservice.controller;

import com.quizz.userservice.dto.AuthenticationRequest;
import com.quizz.userservice.dto.AuthenticationResponse;
import com.quizz.userservice.dto.RegisterRequest;
import com.quizz.userservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        try {
            service.validateToken(token);
        } catch (Exception e) {
            throw new RuntimeException("token is invalid");
        }
        return "Token is valid";
    }
}
