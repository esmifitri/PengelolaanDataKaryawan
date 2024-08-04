package com.example.controller;


import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            boolean isAuthenticated = loginService.authenticateUser(username, password);
            if (isAuthenticated) {
                res.put("status", true);
                res.put("message", "Login berhasil");
            } else {
                res.put("status", false);
                res.put("message", "Invalid username atau password");
            }
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.put("status", false);
            res.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

}
