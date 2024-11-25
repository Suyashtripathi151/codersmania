package com.jestersClub.codersMania.service.profile;

import com.jestersClub.codersMania.entity.Users;
import com.jestersClub.codersMania.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    UserRepository userRepository;

    public  Users getUser(String email){
        Users user = userRepository.findByEmail(email);
        return user;

    }
}
