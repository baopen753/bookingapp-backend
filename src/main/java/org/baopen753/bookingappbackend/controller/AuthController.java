package org.baopen753.bookingappbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/register")
    public String register() {
        return "Register successful";
    }

    @GetMapping("/login")
    public String login() {
        return "Login successful";
    }
}
