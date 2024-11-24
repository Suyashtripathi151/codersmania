package com.jestersClub.codersMania.controller.registration;

import com.jestersClub.codersMania.entity.Users;
import com.jestersClub.codersMania.service.registration.RegisterService;
import com.jestersClub.codersMania.service.verification.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private VerificationTokenService verificationTokenService;

    @PostMapping("/user")
    public ResponseEntity<HashMap<String, Object>> registerUser(@RequestBody Users user) {
        HashMap<String, Boolean> registrationResult = registerService.registerUser(user);
        HashMap<String, Object> response = new HashMap<>();
        if (registrationResult.get("success")) {
            response.put("message", "User registered, please check your email for verification.");
            response.put("success", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("message", "Registration failed: Email already in use.");
            response.put("success", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/verification/{token}")
    public ResponseEntity<HashMap<String, Object>> confirmEmail(
            @PathVariable("token") String token,
            @RequestBody HashMap<String, String> emailAndPassword) {

        boolean verified = verificationTokenService.verifyUser(emailAndPassword,token);
        HashMap<String, Object> response = new HashMap<>();

        if (verified) {
            response.put("message", "Email verified successfully!");
            response.put("success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Invalid or expired token.");
            response.put("success", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/deleteAll")
    public ResponseEntity<HashMap<String, Object>> deleteAllUsers() {
        boolean result = registerService.deleteAllUsers();
        HashMap<String, Object> response = new HashMap<>();
        if (result) {
            response.put("message", "All users deleted successfully.");
            response.put("success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Failed to delete users.");
            response.put("success", false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
