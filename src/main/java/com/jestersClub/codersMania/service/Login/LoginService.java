package com.jestersClub.codersMania.service.Login;

import com.jestersClub.codersMania.entity.Users;
import com.jestersClub.codersMania.repositories.UserRepository;
import com.jestersClub.codersMania.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtil;

    public String login(String email, String password) {
        Users user = userRepository.findByEmail(email);

        if (user == null) {
            System.out.println("User not found");
            return null;
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Wrong password");
            return null;
        }

        if (!user.getIsVerified()) {
            System.out.println("Unverified user");
            return null;
        }

        // Generate JWT token
        return jwtUtil.generateToken(email);
    }
}
