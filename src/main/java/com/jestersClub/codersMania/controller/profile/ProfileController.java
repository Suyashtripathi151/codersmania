package com.jestersClub.codersMania.controller.profile;

import com.jestersClub.codersMania.entity.Users;
import com.jestersClub.codersMania.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController()
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @GetMapping("/{email}")
    public Users getUser(
            @PathVariable("email") String email){
                return  profileService.getUser(email);

    }

}
