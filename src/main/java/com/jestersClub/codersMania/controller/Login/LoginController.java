package com.jestersClub.codersMania.controller.Login;

import com.jestersClub.codersMania.service.Login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        String token = loginService.login(email, password);
        if (token != null) {
            return ResponseEntity.ok(Map.of("jwtToken", token));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password"));
        }
    }

    @GetMapping("/forget")
    public void forgetPassword() {
        // To be implemented
    }
}
