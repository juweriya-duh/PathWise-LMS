package com.juwe.lms.controller;

import com.juwe.lms.entity.User;
import com.juwe.lms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User newUser) {
        return authService.register(newUser);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        return authService.login(email, password);
    }
}