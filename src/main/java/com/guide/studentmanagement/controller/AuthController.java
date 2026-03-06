package com.guide.studentmanagement.controller;

import com.guide.studentmanagement.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        // Authenticate username and password
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.get("username"),
                request.get("password")
            )
        );

        // Generate JWT token
        String token = jwtUtil.generateToken(authentication.getName());

        // Return token
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("username", authentication.getName());
        response.put("message", "Login successful!");
        return response;
    }
}
