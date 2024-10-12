package com.jestersClub.codersMania.service.registration;

import com.jestersClub.codersMania.entity.Users;
import com.jestersClub.codersMania.repositories.UserRepository;
import com.jestersClub.codersMania.repositories.VerificationTokenRepository;
import com.jestersClub.codersMania.service.verification.VerificationTokenService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private VerificationTokenService verificationTokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public HashMap<String, Boolean> registerUser(Users user) {
        HashMap<String, Boolean> result = new HashMap<>();

        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            result.put("success", false);
            return result; // Email already in use
        }

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set isVerified to false by default
        user.setIsVerified(false);

        // Save user to the database
        userRepository.save(user);

        // Create verification token
        verificationTokenService.createVerificationToken(user);

        result.put("success", true);
        return result; // User registered successfully
    }



    @Transactional
    public boolean deleteAllUsers() {
        // First, delete all tokens associated with the users
        verificationTokenRepository.deleteAll(); // assuming you have a VerificationTokenRepository

        // Then delete all users
        userRepository.deleteAll();
        return true;
    }

}
