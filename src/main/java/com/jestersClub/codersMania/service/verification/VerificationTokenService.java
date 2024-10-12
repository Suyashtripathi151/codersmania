package com.jestersClub.codersMania.service.verification;

import com.jestersClub.codersMania.entity.Users;
import com.jestersClub.codersMania.entity.VerificationToken;
import com.jestersClub.codersMania.repositories.UserRepository;
import com.jestersClub.codersMania.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

@Service
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final int EXPIRATION_TIME_IN_MINUTES = 15; // Set your desired expiration time

    // Create token for a user
    public VerificationToken createVerificationToken(Users user) {
        VerificationToken token = new VerificationToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setEmail(user.getEmail());
        token.setExpiryDate(LocalDateTime.now().plus(EXPIRATION_TIME_IN_MINUTES, ChronoUnit.MINUTES));
        verificationTokenRepository.save(token);
        return token;
    }

    public boolean validateToken(String email, String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByEmail(email);
        String correctToken = verificationToken.getToken();

        Users user = userRepository.findByEmail(email);
        if(Objects.equals(token,correctToken)){
            if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
                System.out.println("Token is expired");
                return false;
            }
            else {
               user.setIsVerified(true);
               userRepository.updateIsVerifiedByEmail(email);
               return true;
            }
        }

        else{
            System.out.println("Wrong Token");
            return false;
        }
    }

    public boolean verifyUser(HashMap<String, String> emailAndPassword, String token){
        String email = emailAndPassword.get("email");
        String password = emailAndPassword.get("password");

        boolean isCorrectCredentials = validateCredentials(email,password);
        if(isCorrectCredentials == true){
            boolean isTokenCorrect = validateToken(email,token);
            return isTokenCorrect;
        }
        else {
            return false;
        }

    }

    public boolean validateCredentials(String email, String password) {
        Users users = userRepository.findByEmail(email);
            String encryptedPassword = users.getPassword();
            boolean alreadVerified = checkIfAlreadyVerified(email);
            if(alreadVerified == true){
                System.out.println("Already Verified ");
                return true;
            }
            else{
                if (passwordEncoder.matches(password, encryptedPassword)) {
                    System.out.println("Password is correct");
                    return true;
                }
                else {
                    System.out.println("Password is incorrect");
                    return false;
                }
            }


    }

    public boolean checkIfAlreadyVerified(String email){
        Users user = userRepository.findByEmail(email);
        if(user.getIsVerified()){
            return true;
        }
        else {
            return  false;
        }
    }


}
