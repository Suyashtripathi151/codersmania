package com.jestersClub.codersMania.service.Login;

import com.jestersClub.codersMania.entity.Users;
import com.jestersClub.codersMania.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public boolean login(String email ,String password){
        Users users = userRepository.findByEmail(email);
        String pass = users.getPassword();
        if (passwordEncoder.matches(password, pass)) {
            System.out.println("true");
            boolean isVerified = users.getIsVerified();
            if (isVerified == true) {
                return true;
            } else {
                System.out.println("Unverified user");
                return false;
            }

        } else {
            System.out.println("wrong password");
            return false;
        }
    }



}
